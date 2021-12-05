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
import android.widget.Toast

import com.example.hudway.databinding.ActivityMapsBinding
import com.example.hudway.fragments.MainHeaderFragment
import com.example.hudway.fragments.NavigationHeaderFragment
import com.example.hudway.interfaces.NavigationPasser

import androidx.constraintlayout.widget.ConstraintLayout
import com.google.gson.Gson
import org.w3c.dom.Text
import java.net.HttpURLConnection
import java.net.URL


class MapsActivity : AppCompatActivity(), OnMapReadyCallback, NavigationPasser {
    fun onclickbtn (view: View)
    {
        val start = findViewById<View>(R.id.address_start) as EditText
        val end = findViewById<View>(R.id.address_end) as EditText
        val start_text = start.text.toString()
        val end_text = end.text.toString()
        val url = "http://hudwayapi.my/route/get-route?key=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hbnktc2l0ZS5vcmciLCJhdWQiOiJo" +
                "dHRwOlwvXC9hbnktc2l0ZS5jb20iLCJpYXQiOjEzNTY5OTk1MjQsIm5iZiI6MTM1NzAwMDAwMCwiZGF0YSI6eyJpZCI6MSwiZW1haWwiOiJ0ZXN0QHF3ZSJ9fQ.NfrbogiNC8KnGtxpjG2blR89Pl-seKB6GDQEn_QPE6o&from=" +
                start_text+"&to="+ end_text +"&onlyTurns=true\")"
        val connection = URL(url).openConnection() as HttpURLConnection
        try {
            connection.connect()
            val marshrut = connection.inputStream.use{it.reader().use{reader-> reader.readText()}}
        }finally {
            connection.disconnect()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_maps)

        if (savedInstanceState == null) {
            val mainHeaderFragment =  MainHeaderFragment()
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
