package es.alesagal.wifigps

import android.app.Service
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import java.util.*
import android.os.Looper
import android.widget.Toast
import es.alesagal.wifigps.R.mipmap.ic_launcher
import android.graphics.drawable.BitmapDrawable
import android.app.NotificationManager
import android.net.wifi.WifiManager
import android.support.v7.app.NotificationCompat
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.wifi.WifiInfo






class LocationService : Service(), LocationListener {
    private val min_time_for_updates = 1000 * 60 * 1L // 1 minute
    private val min_distance_for_updates = 10f // 10 meters

    private lateinit var mTimer: Timer
    private lateinit var mHandler: Handler

    private lateinit var mWifiManger: WifiManager

    private lateinit var mLocationManager: LocationManager
    private var isGpsEnabled = false
    private var wasConnected = false

    private var mLocation: Location? = null

    var latitude: Double? = null
        get() = mLocation?.latitude

    var longitude: Double? = null
        get() = mLocation?.longitude

    override fun onCreate() {
        super.onCreate()

        mLocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        isGpsEnabled = mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

        mWifiManger = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        mTimer = Timer()
        mHandler = Handler(Looper.myLooper())
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mTimer.scheduleAtFixedRate(checkLocation(), 0, 5000) // Schedule task
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mTimer.cancel()
    }

    // TimerTask used for the Service.
    private fun checkLocation(): TimerTask {
        return object : TimerTask() {
            override fun run() {
                mHandler.post({ updateLocation() })
            }
        }
    }

    // Gets the current location using the provider.
    fun updateLocation() {
        try {
            // Checks first the network provider.
            if (isGpsEnabled) {
                mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                        min_time_for_updates, min_distance_for_updates, this as LocationListener)
                mLocation = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                if (!wasConnected && checkWifiOnAndConnected())
                    testNotification("connected")
                else
                    testNotification("disconnected")

                wasConnected = checkWifiOnAndConnected()

            } else
                mLocation = null

        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }

    // Checks if it is connected.
    private fun checkWifiOnAndConnected(): Boolean {
        if (mWifiManger.isWifiEnabled) { // Wi-Fi adapter is ON.
            val wifiInfo = mWifiManger.connectionInfo

            if (wifiInfo.networkId == -1)
                return false // Not connected to an access point.

            return true // Connected to an access point.
        } else
            return false // Wi-Fi adapter is OFF.
    }

    private fun switchWifi(on: Boolean) {
        mWifiManger.isWifiEnabled = on
    }


    private fun testNotification(state: String) {
        val mGestor = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val b = NotificationCompat.Builder(this)
        b.setSmallIcon(R.drawable.ic_launcher_background)
        b.setContentTitle(state)
        b.setContentText("$latitude, $longitude") // Texto (2º línea).
        b.setTicker(state)
        mGestor.notify(1, b.build())
    }

    fun stop() = stopSelf()

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }


    // SavedLocation listener methods
    override fun onProviderEnabled(p0: String?) {
    }

    override fun onProviderDisabled(p0: String?) {
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
    }

    override fun onLocationChanged(location: Location) {
    }
}
