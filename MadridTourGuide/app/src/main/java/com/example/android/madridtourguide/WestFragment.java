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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WestFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static WestFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        WestFragment fragment = new WestFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the view from the XML resource ID in sight_layout.xml
        View rootView = inflater.inflate(R.layout.sight_layout, container, false);

        // Create a list of sights
        final ArrayList<Sight> sights = new ArrayList<Sight>();
        sights.add(new Sight(R.drawable.ic_casa_campo, R.string.casa_campo_location, R.string.casa_campo_metro, R.string.casa_campo_bus, R.string.casa_campo));
        sights.add(new Sight(R.drawable.ic_catedral_almudena, R.string.catedral_almudena_location, R.string.catedral_almudena_metro, R.string.catedral_almudena_bus, R.string.catedral_almudena));
        sights.add(new Sight(R.drawable.ic_museo_america, R.string.museo_america_location, R.string.museo_america_metro, R.string.museo_america_bus, R.string.museo_america));
        sights.add(new Sight(R.drawable.ic_palacio_real, R.string.palacio_real_location, R.string.palacio_real_metro, R.string.palacio_real_bus, R.string.palacio_real));
        sights.add(new Sight(R.drawable.ic_museo_traje, R.string.museo_traje_location, R.string.museo_traje_metro, R.string.museo_traje_bus, R.string.museo_traje));
        sights.add(new Sight(R.drawable.ic_plaza_oriente, R.string.plaza_oriente_location, R.string.plaza_oriente_metro, R.string.plaza_oriente_bus, R.string.plaza_oriente));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Sight}s. The
        // adapter knows how to create list items for each item in the list.
        SightAdapter adapter = new SightAdapter(getActivity(), sights, R.color.blue_background);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;

    }
}
