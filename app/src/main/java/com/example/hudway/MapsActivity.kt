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

import com.example.hudway.databinding.ActivityMapsBinding
import com.example.hudway.fragments.MainHeaderFragment
import com.example.hudway.fragments.NavigationHeaderFragment
import com.example.hudway.interfaces.NavigationPasser


class MapsActivity : AppCompatActivity(), OnMapReadyCallback, NavigationPasser {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        if (savedInstanceState == null) {
            val mainHeaderFragment = MainHeaderFragment()
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.topFragmentContainer,
                    mainHeaderFragment
                ).commit()
        }

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

    override fun passCoords(start : LatLng, finish : LatLng) {
        val bundle = Bundle()

        val transaction = this.supportFragmentManager.beginTransaction()
        val navigetionHeaderFragment = NavigationHeaderFragment()

        transaction.replace(
            R.id.topFragmentContainer,
            navigetionHeaderFragment)

        transaction.commit()
        transaction.addToBackStack(null)
    }
}
