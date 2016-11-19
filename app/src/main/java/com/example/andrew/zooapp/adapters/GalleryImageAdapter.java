package com.example.andrew.zooapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.andrew.zooapp.R;
import com.example.andrew.zooapp.models.GalleryImage;
import com.squareup.picasso.Picasso;

/**
 * Created by Andrew on 19.11.2016.
 */

public class GalleryImageAdapter extends ArrayAdapter<GalleryImage>{
    public GalleryImageAdapter(Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {

            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_gallery_thumbnail, parent, false);
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag( holder );

        } else {

            holder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(getContext()).load(getItem(position).getThumbnail() ).into( holder.image);
        return convertView;
    }

    private class ViewHolder {

        ImageView image;

    }
}
