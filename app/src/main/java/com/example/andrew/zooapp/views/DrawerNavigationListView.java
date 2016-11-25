package com.example.andrew.zooapp.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.andrew.zooapp.R;
import com.example.andrew.zooapp.adapters.DrawerNavigationListAdapter;
import com.example.andrew.zooapp.events.DrawerSectionItemClickedEvent;
import com.example.andrew.zooapp.utils.EventBus;

/**
 * Created by Andrew on 18.11.2016.
 */

public class DrawerNavigationListView extends ListView implements AdapterView.OnItemClickListener {
    public DrawerNavigationListView(Context context) {
        this(context, null);
    }

    public DrawerNavigationListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawerNavigationListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        DrawerNavigationListAdapter adapter = new DrawerNavigationListAdapter( getContext(), 0 );
        /*adapter.add( "Exhibits" );
        adapter.add( "Gallery" );
        adapter.add( "Maps" );*/
        //adapter.add( getContext().getString( R.string.section_exhibits));
        adapter.add( getContext().getString( R.string.section_visitors));
        adapter.add( getContext().getString( R.string.section_mammals));

        adapter.add( getContext().getString( R.string.section_birds));
        adapter.add( getContext().getString( R.string.section_gallery));
        adapter.add( getContext().getString( R.string.section_map));

        setAdapter( adapter );

        setOnItemClickListener( this );
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        EventBus.getInstance().post( new DrawerSectionItemClickedEvent( (String) parent.getItemAtPosition( position ) ) );
        //Toast.makeText( getContext(), "Section Clicked: " + parent.getItemAtPosition( position ), Toast.LENGTH_SHORT ).show();
    }
}