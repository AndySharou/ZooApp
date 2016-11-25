package com.example.andrew.zooapp.fragments.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrew.zooapp.R;

/**
 * Created by Andrew on 24.11.2016.
 */

public class AddressTabFragment extends Fragment {

    public static AddressTabFragment getInstance() {
        // Required empty public constructor
        AddressTabFragment fragment = new  AddressTabFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_address, container, false);
    }
}
