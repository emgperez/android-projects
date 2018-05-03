package com.example.android.madridtourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A Fragment subclass to represent locations in the center of the city.
 */
public class CenterFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static CenterFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        CenterFragment fragment = new CenterFragment();
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
        sights.add(new Sight(R.drawable.ic_museo_reina_sofia, R.string.museo_reina_sofia_location, R.string.museo_reina_sofia_metro, R.string.museo_reina_sofia_bus, R.string.museo_reina_sofia));
        sights.add(new Sight(R.drawable.ic_museo_thyssen, R.string.museo_thyssen_location, R.string.museo_thyssen_metro, R.string.museo_thyssen_bus, R.string.museo_thyssen));
        sights.add(new Sight(R.drawable.ic_plaza_mayor, R.string.plaza_mayor_location, R.string.plaza_mayor_metro, R.string.plaza_mayor_bus, R.string.plaza_mayor));
        sights.add(new Sight(R.drawable.ic_puerta_del_sol, R.string.puerta_del_sol_location, R.string.puerta_del_sol_metro, R.string.puerta_del_sol_bus, R.string.puerta_del_sol));
        sights.add(new Sight(R.drawable.ic_rastro, R.string.rastro_location, R.string.rastro_metro, R.string.rastro_bus, R.string.rastro));
        sights.add(new Sight(R.drawable.ic_plaza_cebada, R.string.plaza_cebada_location, R.string.plaza_cebada_metro, R.string.plaza_cebada_bus, R.string.plaza_cebada));

        // Create an {@link SightAdapter}, whose data source is a list of {@link Sight}s. The
        // adapter knows how to create list items for each item in the list.
        SightAdapter adapter = new SightAdapter(getActivity(), sights, R.color.blue_background);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;

    }
}
