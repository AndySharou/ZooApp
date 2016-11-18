package com.example.andrew.zooapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Andrew on 18.11.2016.
 */

public class Animal implements Parcelable{
    private String name;
    private String species;
    private String bclass;
    private String order;
    private String family;
    private String description;
    private String thumbnail;
    private String image;

    public Animal () {

    }

    public Animal ( String name, String species,String bclas, String order, String family, String description, String thumbnail, String image) {

        this.name = name;
        this.species = species;
        this.bclass = bclas;
        this.order = order;
        this.family = family;
        this.description = description;
        this.thumbnail = thumbnail;
        this.image = image;
    }

    public Animal( Parcel source) {

        name = source.readString();
        species = source.readString();
        bclass = source.readString();
        order = source.readString();
        family = source.readString();
        description = source.readString();
        thumbnail = source.readString();
        image = source.readString();
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBclass() {
        return bclass;
    }

    public void setBclass(String bclass) {
        this.bclass = bclass;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        applyDefaultValues();
        dest.writeString( name );
        dest.writeString( species );
        dest.writeString( bclass );
        dest.writeString( order );
        dest.writeString( family );
        dest.writeString( description );
        dest.writeString( thumbnail );
        dest.writeString( image );


    }

    private void applyDefaultValues() {

        if ( name == null )
            name = "";
        if ( species == null )
            species = "";
        if ( bclass == null )
            bclass = "";
        if ( order == null )
            order = "";
        if ( family == null )
            family = "";
        if ( description == null )
            description = "";
        if ( thumbnail == null )
            thumbnail = "";
        if ( image == null )
            image = "";

    }

    public  static Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel source) {
            return new Animal(source);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };


}
