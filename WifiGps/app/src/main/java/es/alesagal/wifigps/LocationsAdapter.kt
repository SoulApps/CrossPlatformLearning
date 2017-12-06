package es.alesagal.wifigps

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import es.alesagal.wifigps.models.SavedLocation


/**
 * Created by aleja on 27/07/2017.
 */
class LocationsAdapter(var data: ArrayList<SavedLocation>) : RecyclerView.Adapter<LocationsAdapter.ViewHolder>() {

    private var mData: ArrayList<SavedLocation> = ArrayList(data)

    fun add(savedLocation: SavedLocation) {
        mData.add(savedLocation)
        notifyItemInserted(mData.size)
    }

    fun addAll(data: ArrayList<SavedLocation>) {
        mData.clear()
        mData.addAll(data)
        notifyItemInserted(mData.size)
    }

    fun remove(position: Int) {
        mData.remove(mData[position])
        notifyItemRemoved(position)
    }

    fun isEmpty() = mData.size == 0

    override fun getItemCount() = mData.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.location_row_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LocationsAdapter.ViewHolder, position: Int) = holder.bind(data[position])


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val lblWifiName: TextView = itemView.findViewById(R.id.lblWifiName)
        private val lblLastTime: TextView = itemView.findViewById(R.id.lblLastTime)

        fun bind(savedLocation: SavedLocation) {
            val latitude = savedLocation.latitude
            val longitude = savedLocation.longitude

            lblWifiName.text = savedLocation.wifiName
            lblLastTime.text = savedLocation.lastTime.toString()
        }
    }
}