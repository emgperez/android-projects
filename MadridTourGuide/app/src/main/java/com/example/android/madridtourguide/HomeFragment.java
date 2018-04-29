package com.example.android.madridtourguide;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ImageView cityImage;
    private TextView linkOne;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the view from the XML resource ID in word_list.xml
        View rootView = inflater.inflate(R.layout.activity_home, container, false);

        // Initialize layout objects
        cityImage = (ImageView) rootView.findViewById(R.id.city_picture);
        linkOne = (TextView) rootView.findViewById(R.id.link_one);


        return rootView;
    }
}

