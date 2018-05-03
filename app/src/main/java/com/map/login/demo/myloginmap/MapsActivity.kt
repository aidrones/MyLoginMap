package com.map.login.demo.myloginmap

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException


class MapsActivity : AppCompatActivity(), OnMapReadyCallback{

    private lateinit var mMap: GoogleMap

    var rvc = LatLng(0.0, 0.0)
    val ZOOM_LEVEL = 15.0f

    private var latitude: Double = 0.0
    private var longitude: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        var geocodeMatches: List<Address>? = null

        try
        {
            geocodeMatches = Geocoder(this).getFromLocationName(
                    "3301 N Mulford Rd, Rockford, IL 61114", 1)
        }
        catch (e: IOException)
        {
            e.printStackTrace()
        }

        if (geocodeMatches != null)
        {
            latitude = geocodeMatches[0].latitude
            longitude = geocodeMatches[0].longitude
            rvc = LatLng(latitude, longitude)
        };
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val ny =  LatLng (40.73, -73.99)   // this is New York
        mMap.addMarker(MarkerOptions()
                .position(ny)
                .title("New York City")
                .snippet("New York City, NY"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ny, 10.0f))


        // Add a marker in Illinois and move the camera
        val illinois =  LatLng (42.271394, -89.095)
        mMap.addMarker(MarkerOptions()
                .position(illinois)
                .title("Rockford")
                .snippet("Rockford, Illinois"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(illinois, 10.0f))


        val position =  LatLng (42.2739, -89.0930)
        mMap.addMarker(MarkerOptions()
                .position(position)
                .title("Coronado Theatre")
                .snippet("Coronado Performing Arts Center"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 10.0f))


        val rvc =  LatLng (42.3080, -88.9929)
        mMap.addMarker(MarkerOptions()
                .position(rvc)
                .title("RockValleyCollege")
                .snippet("Two year community college"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rvc, 10.0f))


        /*
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))*/


        /* // another way to do
        with(googleMap)
        {
            moveCamera(CameraUpdateFactory.newLatLngZoom(RVC, ZOOM_LEVEL))
            addMarker(MarkerOptions().position(RVC).title("RockValleyCollege").snippet("Two year community college"))
        }*/
    }
}
