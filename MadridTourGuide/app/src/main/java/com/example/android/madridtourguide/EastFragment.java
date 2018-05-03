package com.example.android.madridtourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A Fragment subclass to represent locations in the east of the city.
 */
public class EastFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static EastFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        EastFragment fragment = new EastFragment();
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
        sights.add(new Sight(R.drawable.ic_museo_prado, R.string.museo_prado_location, R.string.museo_prado_metro, R.string.museo_prado_bus, R.string.museo_prado));
        sights.add(new Sight(R.drawable.ic_parque_retiro, R.string.parque_retiro_location, R.string.parque_retiro_metro, R.string.parque_retiro_bus, R.string.parque_retiro));
        sights.add(new Sight(R.drawable.ic_puerta_alcala, R.string.puerta_alcala_location, R.string.puerta_alcala_metro, R.string.puerta_alcala_bus, R.string.puerta_alcala));
        sights.add(new Sight(R.drawable.ic_estacion_atocha, R.string.estacion_atocha_location, R.string.atocha_metro, R.string.atocha_bus, R.string.estacion_atocha));
        sights.add(new Sight(R.drawable.ic_fabrica_tapices, R.string.fabrica_tapices_location, R.string.fabrica_tapices_metro, R.string.fabrica_tapices_bus, R.string.fabrica_tapices));

        // Create an {@link SightAdapter}, whose data source is a list of {@link Sight}s. The
        // adapter knows how to create list items for each item in the list.
        SightAdapter adapter = new SightAdapter(getActivity(), sights, R.color.blue_background);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;

    }
}

