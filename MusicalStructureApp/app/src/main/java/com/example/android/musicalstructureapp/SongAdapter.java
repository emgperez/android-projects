package com.example.android.musicalstructureapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by emilio on 03/04/2018.
 */

public class SongAdapter extends ArrayAdapter<Song>{



    public SongAdapter(Activity context, ArrayList<Song> songs) {

        // Initialize the adapter internal storage
        super(context, 0, songs);


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }

        // Get the song object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the song_item.xml layout with the song name text view
        TextView songName = (TextView) listItemView.findViewById(R.id.song_name);
        songName.setText(currentSong.getName());

        // Find the TextView in the song_item.xml layout with the artist name text view
        TextView songArtist = (TextView) listItemView.findViewById(R.id.artist_name);
        songArtist.setText(currentSong.getArtistName());

        // Find the TextView in the song_item.xml layout with the album name text view
        TextView songAlbum = (TextView) listItemView.findViewById(R.id.album_name);
        songAlbum.setText(currentSong.getAlbumName());

        // Find the ImageView in the song_item.xml layout with the ID song_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.song_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(currentSong.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}