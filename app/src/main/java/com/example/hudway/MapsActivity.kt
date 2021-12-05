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
import androidx.appcompat.app.AlertDialog


import com.example.hudway.fragments.MainHeaderFragment
import com.example.hudway.fragments.NavigationHeaderFragment
import com.example.hudway.interfaces.NavigationPasser

import java.net.HttpURLConnection
import java.net.URL

import java.io.BufferedReader
import java.io.InputStreamReader

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, NavigationPasser {
    fun requestGET(url: String): String {
        val obj = URL(url)
        val con = obj.openConnection() as HttpURLConnection
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 YaBrowser/21.11.0 Yowser/2.5 Safari/537.36")
        con.requestMethod = "GET"
        val responseCode = con.responseCode
        println("Response Code :: $responseCode")
        return if (responseCode == HttpURLConnection.HTTP_OK) { // connection ok
            val input =
                BufferedReader(InputStreamReader(con.inputStream))
            var inputLine: String?
            val response = StringBuffer()
            while (input.readLine().also { inputLine = it } != null) {
                response.append(inputLine)
            }
            input.close()
            response.toString()
        } else {
            "123"
        }
    }

    fun onClick_nav (view: View)
    {
//        val start = findViewById<View>(R.id.address_start) as EditText
//        val end = findViewById<View>(R.id.address_end) as EditText
//        val start_text = start.text.toString()
//        val end_text = end.text.toString()

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
