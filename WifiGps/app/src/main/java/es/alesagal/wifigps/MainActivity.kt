package es.alesagal.wifigps

import android.Manifest
import android.content.Context
import android.net.wifi.WifiManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.app.ActivityCompat
import android.content.pm.PackageManager
import android.support.v7.app.AlertDialog
import android.content.Intent
import android.app.Activity
import android.net.Uri
import android.provider.Settings
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.View

class MainActivity : AppCompatActivity() {

    private val gpsRequest = 1

    private lateinit var mLocationsAdapter: LocationsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //lstWifis.adapter = mLocationsAdapter

        initViews()
    }

    private fun initViews() {
        /*if (mLocationsAdapter.isEmpty())
            lblEmptyList.visibility = View.VISIBLE*/

        btnRequestlocationPermission.setOnClickListener {
            requestAccessFineLocationPermission()
        }
    }

    override fun onStart() {
        super.onStart()
        //Request the location permission if needed.
        requestAccessFineLocationPermission()
    }

    private fun requestAccessFineLocationPermission() {
        if (PackageManager.PERMISSION_GRANTED != ContextCompat
                .checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)) {

            // If the user has declined it at least once, a dialog is shown and then
            // it request permission.
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                showPermissionInfoDialog()
            } else {
                // Ask for permission if it is the first time.
                ActivityCompat.requestPermissions(this,
                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), gpsRequest)
            }
        } else {
            //Has permissions.
           startLocationService()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == gpsRequest) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startLocationService()
            } else {
                // The request button is shown.
                btnRequestlocationPermission.visibility = View.VISIBLE

                // Ask again.
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.ACCESS_FINE_LOCATION)) {
                    Snackbar.make(btnRequestlocationPermission, "Action not available", Snackbar.LENGTH_LONG)
                            .show()
                } else {
                    // Do not ask again.
                    Snackbar.make(btnRequestlocationPermission, "Action not available", Snackbar.LENGTH_LONG)
                            .setAction("Change settings", { _ ->
                                startInstalledAppDetailsActivity(this@MainActivity)
                            })
                            .show()
                }
            }
        }
    }

    private fun startLocationService() {
        // The request button is hidden.
        btnRequestlocationPermission.visibility = View.INVISIBLE

        // The service is started.
        startService(Intent(this, LocationService::class.java))
    }

    fun startInstalledAppDetailsActivity(context: Activity) {
        val intent = Intent()
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        intent.addCategory(Intent.CATEGORY_DEFAULT)
        intent.data = Uri.parse("package:" + context.packageName)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
        context.startActivity(intent)
    }

    private fun showPermissionInfoDialog() {
        AlertDialog.Builder(this)
                .setTitle("Allow permissions")
                .setMessage("GPS data in needed for the App to work")
                .setPositiveButton(android.R.string.ok, { _, _ ->
                    ActivityCompat.requestPermissions(this@MainActivity,
                            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                            gpsRequest)
                }).show()
    }
}
