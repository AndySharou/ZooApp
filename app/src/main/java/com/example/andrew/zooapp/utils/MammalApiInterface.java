package com.example.andrew.zooapp.utils;

import com.example.andrew.zooapp.models.Animal;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Andrew on 21.11.2016.
 */

public interface MammalApiInterface {

    @GET( "/ZooAppMammals.json" )
    void getStreams(Callback<List<Animal>> callback );

}
