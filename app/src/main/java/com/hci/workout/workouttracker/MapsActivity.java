package com.hci.workout.workouttracker;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.os.Bundle;

public class MapsActivity extends Activity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng carMikeLatLng = new LatLng(35.794855, -78.700409);
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(carMikeLatLng, 13));
        map.getUiSettings().setZoomControlsEnabled(true);
        map.addMarker(new MarkerOptions()
                .title("Carmichael Gymnasium")
                .snippet("The most popular gym in NC.")
                .position(carMikeLatLng));

    }
}