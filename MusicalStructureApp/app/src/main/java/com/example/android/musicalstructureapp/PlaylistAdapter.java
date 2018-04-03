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
 * Created by emilio on 02/04/2018.
 */

public class PlaylistAdapter extends ArrayAdapter<Playlist>{



    public PlaylistAdapter(Activity context, ArrayList<Playlist> lists) {

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
                    R.layout.playlist_item, parent, false);
        }

        // Get the playlist object located at this position in the list
        Playlist currentPlaylist = getItem(position);

        // Find the TextView in the playlist_item.xml.xml layout with the playlist name text view
        TextView playlistName = (TextView) listItemView.findViewById(R.id.playlist_name_text_view);
        playlistName.setText(currentPlaylist.getName());

        // Find the TextView in the playlist_itemitem.xml layout with the playlist play mode text view
        TextView playlistPlayMode = (TextView) listItemView.findViewById(R.id.playlist_mode_text_view);

        // Get the play mode for the current playlist
        playlistPlayMode.setText(currentPlaylist.getPlayMode());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
