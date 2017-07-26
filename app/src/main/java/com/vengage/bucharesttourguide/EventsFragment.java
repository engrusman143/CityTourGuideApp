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
 * Fragment which presents a list of events
 */

public class EventsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.element_list, container, false);

        // Array of elements that will be displayed in the list
        final ArrayList<Element> elements = new ArrayList<Element>();
        elements.add(new Element(
                getString(R.string.shine_festival),
                getString(R.string.shine_festival_address),
                R.drawable.shine_festival,
                44.476682, 26.068009,
                R.string.shine_festival_description));
        elements.add(new Element(
                getString(R.string.plaza_romania),
                getString(R.string.plaza_romania_address),
                R.drawable.plaza,
                44.4404596, 26.0954954,
                R.string.plaza_romania_description));
        elements.add(new Element(
                getString(R.string.mogosoaia_palace),
                getString(R.string.mogosoaia_palace_address),
                R.drawable.palatul_mogosoaia,
                44.41492, 26.092095,
                R.string.mogosoaia_palace_description));
        elements.add(new Element(
                getString(R.string.timeshift_festival),
                getString(R.string.timeshift_festival_address),
                R.drawable.timeshift_festival,
                44.41492, 26.092095,
                R.string.timeshift_festival_description));

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
