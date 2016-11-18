package com.example.andrew.zooapp.fragments;

import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by Andrew on 18.11.2016.
 */

public class ZooMapFragment extends SupportMapFragment{

    public static ZooMapFragment getInstance() {
        ZooMapFragment fragment = new ZooMapFragment();
        return fragment;

    }
}
