package com.example.andrew.zooapp.fragments.tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrew.zooapp.R;
import com.example.andrew.zooapp.models.WorkingHours;
import com.example.andrew.zooapp.utils.EventBus;
import com.example.andrew.zooapp.utils.WorkingHoursApiInterface;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Andrew on 24.11.2016.
 */

public class WorkingHoursTabFragment extends Fragment {

    TextView days, time, cass_time, tech_break, exposition;
    ImageView image;

    public WorkingHoursTabFragment() {
        // Required empty public constructor
    }

    public static WorkingHoursTabFragment getInstance() {
        // Required empty public constructor
        WorkingHoursTabFragment fragment = new WorkingHoursTabFragment();
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_tab_working_hours, container, false);
        days = (TextView)view.findViewById(R.id.days);
        time = (TextView)view.findViewById(R.id.time);
        cass_time = (TextView)view.findViewById(R.id.cass_time);
        tech_break = (TextView)view.findViewById(R.id.tech_break);
        exposition = (TextView)view.findViewById(R.id.exposition);
        return view;

    }


    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint( getString(R.string.working_hours_feed))
                .build();
        final WorkingHoursApiInterface whApiInterface = restAdapter.create(WorkingHoursApiInterface.class);
        Log.e("ZooApp", "Вот тут ещё работает" );

        whApiInterface.getStreams(new Callback<WorkingHours>() {


            @Override
            public void success(WorkingHours workingHours, Response response) {

                Log.e("ZooApp", "Тут ещё что-то пытается" );

                if (!isAdded() || workingHours == null  ) {
                    return;}



                days.setText( workingHours.getDays() );
                time.setText( workingHours.getTime() );
                cass_time.setText( workingHours.getCass_time() );
                tech_break.setText( workingHours.getTech_break() );
                exposition.setText( workingHours.getExpositions() );

            }

            @Override
            public void failure(RetrofitError error) {

                Log.e("ZooApp", "не взлетело working hours" );

            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();

        EventBus.getInstance().register( this );
    }

    @Override
    public void onStop() {
        EventBus.getInstance().unregister( this );
        super.onStop();
    }
}
