package com.example.andrew.zooapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.andrew.zooapp.R;
import com.example.andrew.zooapp.models.Pin;
import com.example.andrew.zooapp.utils.PinsApiInterface;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Andrew on 18.11.2016.
 */

public class ZooMapFragment extends SupportMapFragment{

    public static ZooMapFragment getInstance() {
        ZooMapFragment fragment = new ZooMapFragment();
        return fragment;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CameraPosition position = CameraPosition.builder()
                .target( new LatLng(53.850084, 27.635797) )
                .zoom( 16f )
                .bearing(0.0f)
                .tilt(0.0f)
                .build();

        getMap().animateCamera(CameraUpdateFactory.newCameraPosition( position ), null );
        getMap().setMapType( GoogleMap.MAP_TYPE_HYBRID );
        getMap().setTrafficEnabled( true );

        getMap().getUiSettings().setZoomControlsEnabled( true );

        MarkerOptions options = new MarkerOptions().position( new LatLng(53.849473, 27.633472) );
        options.title("Минский Зоопарк");
        options.icon(BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_BLUE));
        getMap().addMarker(options);

        getMap().setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                marker.showInfoWindow();
                return false;
            }
        });


        RestAdapter adapter = new RestAdapter.Builder().setEndpoint( getString(R.string.map_pins_feed)).build();

        PinsApiInterface pinsApiInterface = adapter.create( PinsApiInterface.class);
        pinsApiInterface.getStreams(new Callback<List<Pin>>() {
            @Override
            public void success(List<Pin> pins, Response response) {

                if (!isAdded() || pins == null || pins.isEmpty() )
                    return;

                for (Pin pin: pins) {

                    MarkerOptions options = new MarkerOptions().position(new LatLng( pin.getLatitude(), pin.getLongitude() ) );
                    options.title(pin.getName());
                    options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN) );
                    getMap().addMarker(options);

                }

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
