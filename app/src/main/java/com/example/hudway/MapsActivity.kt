package com.example.hudway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import android.view.View

import androidx.constraintlayout.widget.ConstraintLayout


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    public fun onClick_StartNav(view: View) { //layout change
        val start_lay = findViewById<View>(R.id.Start_layout) as ConstraintLayout
        val nav_lay = findViewById<View>(R.id.Navigator_layout) as ConstraintLayout
        val nav_lay_down = findViewById<View>(R.id.Navigator_layout_down) as ConstraintLayout
        start_lay.visibility = View.GONE
        nav_lay.visibility = View.VISIBLE
        nav_lay_down.visibility = View.VISIBLE
    }

    public fun onClick_EndNav(view: View) { //layout change
        val start_lay = findViewById<View>(R.id.Start_layout) as ConstraintLayout
        val nav_lay = findViewById<View>(R.id.Navigator_layout) as ConstraintLayout
        val nav_lay_down = findViewById<View>(R.id.Navigator_layout_down) as ConstraintLayout
        nav_lay.visibility = View.GONE
        nav_lay_down.visibility = View.GONE
        start_lay.visibility = View.VISIBLE
    }

    public fun onClick_locate(view: View) { //locate_btn action

    }

    public fun onClick_notifications(view: View) { //notification_btn action

    }

    public fun onClick_fave(view: View) { //fave_btn action

    }

    public fun onClick_options(view: View) { //options_btn action

    }

    public fun onClick_sync(view: View) { //sync_btn action

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps)

        // Get the SupportMapFragment and request notification when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val izhevsk = LatLng(56.8498, 53.2045)
        googleMap.addMarker(
            MarkerOptions()
                .position(izhevsk)
                .title("Marker in Izhevsk (maybe)")
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(izhevsk))
    }

}