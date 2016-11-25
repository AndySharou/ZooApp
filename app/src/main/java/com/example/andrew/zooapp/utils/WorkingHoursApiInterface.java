package com.example.andrew.zooapp.utils;

import com.example.andrew.zooapp.models.WorkingHours;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Andrew on 25.11.2016.
 */

public interface WorkingHoursApiInterface {

    @GET( "/ZooAppWorkingHours.json")
    void getStreams(Callback<WorkingHours> callback);
}
