package com.ignition.testproject.presentation.listOfPlaces

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ignition.testproject.R
import com.ignition.testproject.models.PlaceUnion
import kotlinx.android.synthetic.main.rv_place_group_item.view.*

class PlacesGroupsRVAdapter(private val placeUnion: MutableList<PlaceUnion>) : RecyclerView.Adapter<PlacesGroupsRVAdapter.PlacesGroupsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesGroupsViewHolder {
        return PlacesGroupsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_place_group_item, parent, false))
    }

    override fun getItemCount(): Int = placeUnion.size


    override fun onBindViewHolder(holder: PlacesGroupsViewHolder, position: Int) {
        holder.bind(placeUnion[position])
    }

    inner class PlacesGroupsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(placeUnion: PlaceUnion) {
            itemView.tv_place_name.text = placeUnion.name
        }
    }

    fun updateData(placesGroups: List<PlaceUnion>) {
        this.placeUnion.clear()
        this.placeUnion.addAll(placesGroups)
    }

}