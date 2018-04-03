package com.example.android.musicalstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by emilio on 03/04/2018.
 */

public class ArtistAdapter extends ArrayAdapter<Artist>{


    public ArtistAdapter(Activity context, ArrayList<Artist> lists) {

        // Initialize the adapter internal storage
        super(context, 0, lists);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.artist_item, parent, false);
        }

        // Get the artist object located at this position in the list
        Artist currentArtist = getItem(position);

        // Find the TextView in the artist_item.xml layout with the artist name text view
        TextView artistName = (TextView) listItemView.findViewById(R.id.artist_name_text_view);
        artistName.setText(currentArtist.getName());

        // Find the TextView in the artist_item.xml layout with the artist genre text view
        TextView artistGenre = (TextView) listItemView.findViewById(R.id.artist_genre_text_view);
        artistGenre.setText(currentArtist.getGenre());

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
