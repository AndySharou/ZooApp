package com.example.andrew.zooapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;

import com.example.andrew.zooapp.R;
import com.example.andrew.zooapp.models.Animal;
import com.example.andrew.zooapp.utils.AnimalApiInterface;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Andrew on 18.11.2016.
 */

public class ExhibitsListFragment extends ListFragment{

    public static ExhibitsListFragment getInstance() {

       ExhibitsListFragment fragment = new ExhibitsListFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint( getString(R.string.exhibits_feed))
                .build();
        AnimalApiInterface animalApiInterface = restAdapter.create(AnimalApiInterface.class);

        animalApiInterface.getStreams( new Callback<List<Animal>>() {

            @Override
            public void success(List<Animal> animals, Response response) {

                if (animals == null || animals.isEmpty() )
                    return;

                for (Animal animal:animals) {

                    Log.e("Zoo", animal.getName());
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("Zoo", "Retrofit error " + error.getMessage());
            }
        });
    }
}
