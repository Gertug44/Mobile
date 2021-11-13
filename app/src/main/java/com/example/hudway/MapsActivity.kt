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
import android.widget.EditText

import androidx.constraintlayout.widget.ConstraintLayout
import org.w3c.dom.Text


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    public fun onClick_StartNav(view: View) { //layout change
        val start_lay = findViewById<View>(R.id.Start_layout) as ConstraintLayout
        val nav_lay = findViewById<View>(R.id.Navigator_layout) as ConstraintLayout
        val nav_lay_down = findViewById<View>(R.id.Navigator_layout_down) as ConstraintLayout
        val start = findViewById<View>(R.id.address_start) as EditText
        val end = findViewById<View>(R.id.address_end) as EditText
        val start_text = start.text.toString()
        val end_text = end.text.toString()
        val regex = Regex("\\d+")
        val resultList = regex.findAll(start_text+end_text).map { it.value }.toList()
        start_lay.visibility = View.GONE
        nav_lay.visibility = View.VISIBLE
        nav_lay_down.visibility = View.VISIBLE
        //getapi("http://project.my/index.php?r=api%2Fgetapi&FromLat="+resultList[0]+"&FromLng="+resultList[1]+"&ToLat="+resultList[2]+"&ToLng="+resultList[3])
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
        super.onCreate(s    avedInstanceState)
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