package com.example.hudway.interfaces

import com.google.android.gms.maps.model.LatLng

interface NavigationPasser {
    fun passCoords(start : LatLng, finish : LatLng)
}