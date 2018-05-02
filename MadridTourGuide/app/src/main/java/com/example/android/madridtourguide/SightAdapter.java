package com.example.android.madridtourguide;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by emilio on 26/03/2018.
 */

public class SightAdapter extends ArrayAdapter<Sight>{

    // Background colour ID
    private int mBackgroundColorID;

    public SightAdapter(Activity context, ArrayList<Sight> words, int backgroundColourID) {

        // Initialize the adapter internal storage
        super(context, 0, words);
        mBackgroundColorID = backgroundColourID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Sight} object located at this position in the list
        Sight currentSight = getItem(position);

        // Find the TextView in the list_item.xml layout with the sight name
        TextView sightNameTextView = (TextView) listItemView.findViewById(R.id.sight_name_text_view);
        // Get the location for the current Sight object
        sightNameTextView.setText(currentSight.getName());

        // Find the TextView in the list_item.xml layout with the sight location
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.sight_location_text_view);
        // Get the location for the current Sight object
        locationTextView.setText(currentSight.getLocation());

        // Find the TextView in the list_item.xml layout with the metro stations
        TextView metroTextView = (TextView) listItemView.findViewById(R.id.sight_metro_text_view);
        // Get the location for the current Sight object
        metroTextView.setText(currentSight.getMetroStation());

        // Find the TextView in the list_item.xml layout with the bus stops
        TextView busTextView = (TextView) listItemView.findViewById(R.id.sight_bus_text_view);
        // Get the location for the current Sight object
        busTextView.setText(currentSight.getBusStop());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        iconView.setImageResource(currentSight.getImageResourceId());

        // And now change the color of the LinearLayout for the container
        View sightContainer = listItemView.findViewById(R.id.text_container);

        // Find the color for the background id and set it to the container
        int color = ContextCompat.getColor(getContext(), mBackgroundColorID);
        sightContainer.setBackgroundColor(color);

        // Return the whole list item layout so that it can be shown in the ListView
        return listItemView;
    }
}
