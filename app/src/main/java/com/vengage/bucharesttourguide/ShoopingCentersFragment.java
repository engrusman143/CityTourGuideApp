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
 * Fragment which presents a list of shooping centers
 */

public class ShoopingCentersFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.element_list, container, false);

        // Array of elements that will be displayed in the list
        final ArrayList<Element> elements = new ArrayList<Element>();
        elements.add(new Element(
                getString(R.string.afi_palace), // Element title
                getString(R.string.afi_palace_address), // Element address
                R.drawable.afi, // Element image ID
                44.430609,26.0521352, // Element latitude and longitude
                R.string.afi_palace_description)); // Element description
        elements.add(new Element(
                getString(R.string.baneasa_shooping_city),
                getString(R.string.baneasa_shooping_city_address),
                R.drawable.baneasa,
                44.506667,26.090046,
                R.string.baneasa_shooping_city_description));
        elements.add(new Element(
                getString(R.string.plaza_romania),
                getString(R.string.plaza_romania_address),
                R.drawable.plaza,
                44.4287966,26.035013,
                R.string.plaza_romania_description));
        elements.add(new Element(
                getString(R.string.promenada_mall),
                getString(R.string.promenada_mall_address),
                R.drawable.promenada,
                44.4782338,26.10346,
                R.string.promenada_mall_description));

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
