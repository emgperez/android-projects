package com.example.android.madridtourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A Fragment subclass to represent locations in the north of the city.
 */
public class NorthFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static NorthFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        NorthFragment fragment = new NorthFragment();
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
        sights.add(new Sight(R.drawable.ic_museo_sorolla, R.string.museo_sorolla_location, R.string.museo_sorolla_metro, R.string.museo_sorolla_bus, R.string.museo_sorolla));
        sights.add(new Sight(R.drawable.ic_estatuas_botero, R.string.estatuas_botero_location, R.string.estatuas_botero_metro, R.string.estatuas_botero_bus, R.string.estatuas_botero));
        sights.add(new Sight(R.drawable.ic_fundacion_march, R.string.fundacion_march_location, R.string.fundacion_march_metro, R.string.fundacion_march_bus, R.string.fundacion_march));
        sights.add(new Sight(R.drawable.ic_plaza_dos_mayo, R.string.plaza_dos_mayo_location, R.string.atocha_metro, R.string.atocha_bus, R.string.plaza_dos_mayo));
        sights.add(new Sight(R.drawable.ic_sala_canal_isabel_ii, R.string.sala_canal_location, R.string.sala_canal_metro, R.string.sala_canal_bus, R.string.sala_canal));


        // Create an {@link SightAdapter}, whose data source is a list of {@link Sight}s. The
        // adapter knows how to create list items for each item in the list.
        SightAdapter adapter = new SightAdapter(getActivity(), sights, R.color.blue_background);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;

    }
}


