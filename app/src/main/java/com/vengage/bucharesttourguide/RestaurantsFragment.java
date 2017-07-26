package com.vengage.bucharesttourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Vengage on 6/21/2017.
 *
 * Fragment which presents a list of restaurants
 */

public class RestaurantsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.element_list, container, false);

        // Array of elements that will be displayed in the list
        final ArrayList<Element> elements = new ArrayList<Element>();
        elements.add(new Element(
                getString(R.string.the_artist),
                getString(R.string.the_artist_address),
                R.drawable.the_artist,
                44.449867, 26.088157,
                R.string.the_artist_description));
        elements.add(new Element(
                getString(R.string.casa_bia),
                getString(R.string.casa_bia_address),
                R.drawable.casa_bia,
                44.4182788, 26.06762,
                R.string.casa_bia_description));
        elements.add(new Element(
                getString(R.string.upstairs_rooftop),
                getString(R.string.upstairs_rooftop_address),
                R.drawable.upstairs_rooftop,
                44.4490781, 26.0845307,
                R.string.upstairs_rooftop_description));
        elements.add(new Element(
                getString(R.string.shift_pub),
                getString(R.string.shift_pub_address),
                R.drawable.shift,
                44.4449361,26.1016247,
                R.string.shift_pub_description));

        ListView listView = (ListView) rootView.findViewById(R.id.element_list_view);
        final ElementAdapter listTypeAdapter = new ElementAdapter(getActivity(), elements);
        listView.setAdapter(listTypeAdapter);

        // We set onItemClickListener for each element to start the ElementDescriptionActivity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getActivity(), ElementDescriptionActivity.class);
                intent.putExtra("element", listTypeAdapter.getItem(position));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
