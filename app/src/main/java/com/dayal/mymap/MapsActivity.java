package com.dayal.mymap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private static final LatLng AZADPUR = new LatLng(28.7059494,77.1738023);
    private static final LatLng BPIT = new LatLng(28.7366764,77.112063);
    private static final LatLng PBAGH = new LatLng(28.6637055,77.1195832);
    private static final LatLng VV = new LatLng(28.5535581,77.1601241);

    private Marker azadpur;
    private Marker pBagh;
    private Marker vv;
    private Marker bpit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
        List<Marker> markerList = new ArrayList<>();

        bpit = mMap.addMarker(new MarkerOptions().position(BPIT).title("BPIT"));
        bpit.setTag(0);
        markerList.add(bpit);

        azadpur = mMap.addMarker(new MarkerOptions().position(AZADPUR).title("Azadpur")
        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        azadpur.setTag(0);
        markerList.add(azadpur);

        pBagh = mMap.addMarker(new MarkerOptions().position(PBAGH).title("Punjabi bagh")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        azadpur.setTag(0);
        markerList.add(pBagh);

        vv = mMap.addMarker(new MarkerOptions().position(VV).title("Home"));
        azadpur.setTag(0);
        markerList.add(vv);

        for (Marker m : markerList){
            LatLng latLng = new LatLng(m.getPosition().latitude,m.getPosition().longitude);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,20));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,5));

        }

        // Add a marker and move the camera
//        LatLng bpit = new LatLng(28.7366764,77.112063);
//        mMap.addMarker(new MarkerOptions().position(bpit).title("BPIT"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bpit, 12));     // float value 1 - 20
    }
}
