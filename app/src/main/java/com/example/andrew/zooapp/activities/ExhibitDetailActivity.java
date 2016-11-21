package com.example.andrew.zooapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrew.zooapp.R;
import com.example.andrew.zooapp.models.Animal;
import com.squareup.picasso.Picasso;

/**
 * Created by Andrew on 18.11.2016.
 */

public class ExhibitDetailActivity extends AppCompatActivity{

    public static final String EXTRA_ANIMAL = "extra_animal";
    TextView species, bclass, order, family, description;
    ImageView image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibit_detail);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Animal animal = getIntent().getExtras().getParcelable( EXTRA_ANIMAL );

        species = (TextView)findViewById(R.id.species);
        bclass = (TextView)findViewById(R.id.bclass);
        order = (TextView)findViewById(R.id.order);
        family = (TextView)findViewById(R.id.family);
        description = (TextView)findViewById(R.id.description);
        image = (ImageView)findViewById(R.id.image);

        getSupportActionBar().setTitle( animal.getName() );

        species.setText ( getString(R.string.species) + " " + animal.getSpecies() );
        bclass.setText ( getString(R.string.bclass) + " " + animal.getBclass() );
        order.setText ( getString(R.string.order)+ " " + animal.getOrder() );
        family.setText ( getString(R.string.family) + " " + animal.getFamily() );
        description.setText( animal.getDescription() );
        Picasso.with( this ).load( animal.getImage() ).into( image );
    }
}
