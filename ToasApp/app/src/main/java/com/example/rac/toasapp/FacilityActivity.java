package com.example.rac.toasapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class FacilityActivity extends FragmentActivity implements OnMapReadyCallback {
/* this class renders a square arial view of the Toas waste water facility. The goal is
to have the specific parts of the facility represented by a marker, by which a user can click and bring
up the appropiate troubleshooting protocol.
*
*
* */
    //the amount to zoom into the map at
    final private float mapDepth = 18.3f;
    //Toas water treatment plant general location
    final private double toasLat = 36.3735156;
    final private double toasLong = -105.6561039;

    //Toas water tank marker location
    final private double tankLat = 36.372977777;
    final private double tankLong = -105.6561539;
    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        // Add a marker in Sydney and move the camera
        LatLng ToasWW = new LatLng(toasLat, toasLong);
        mMap.addMarker(new MarkerOptions().position(ToasWW).title(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ToasWW));

        LatLng toasWaterTank = new LatLng(tankLat, tankLong);
        mMap.addMarker(new MarkerOptions().position(toasWaterTank).title(""));
        mMap.setMaxZoomPreference(mapDepth);
        mMap.setMinZoomPreference(mapDepth);
        mMap.getUiSettings().setScrollGesturesEnabled(false);
        mMap.getUiSettings().setAllGesturesEnabled(false);

    }
}
