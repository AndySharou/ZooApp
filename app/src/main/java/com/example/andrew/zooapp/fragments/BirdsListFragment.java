package com.example.andrew.zooapp.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.andrew.zooapp.R;
import com.example.andrew.zooapp.activities.ExhibitDetailActivity;
import com.example.andrew.zooapp.adapters.ExhibitsAdapter;
import com.example.andrew.zooapp.models.Animal;
import com.example.andrew.zooapp.utils.BirdApiInterface;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Andrew on 22.11.2016.
 */

public class BirdsListFragment extends ListFragment {

    private ExhibitsAdapter mAdapter;

    public static BirdsListFragment getInstance() {

        BirdsListFragment fragment = new BirdsListFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setListShown( false );
        getListView().setPadding( 16, 16, 16, 16);
        getListView().setDivider(new ColorDrawable(Color.TRANSPARENT));
        getListView().setDividerHeight( 16 );
        getListView().setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        getListView().setClipToPadding( true );
        mAdapter = new ExhibitsAdapter( getActivity(), 0 );

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint( getString(R.string.birds_feed))
                .build();
        BirdApiInterface birdApiInterface = restAdapter.create(BirdApiInterface.class);

        birdApiInterface.getStreams( new Callback<List<Animal>>() {

            @Override
            public void success(List<Animal> animals, Response response) {

                if (animals == null || animals.isEmpty() || !isAdded() )
                    return;

                for (Animal animal:animals) {

                    //Log.e("Zoo", animal.getName());
                    mAdapter.add( animal );
                }

                mAdapter.notifyDataSetChanged();
                setListAdapter( mAdapter );
                setListShown( true );

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("Zoo", "Retrofit error " + error.getMessage());
            }
        });
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent( getActivity(), ExhibitDetailActivity.class );
        intent.putExtra( ExhibitDetailActivity.EXTRA_ANIMAL, mAdapter.getItem( position ) );
        startActivity( intent );
    }
}