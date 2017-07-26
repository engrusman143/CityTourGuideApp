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
 * Fragment which presents a list of historical sites
 */

public class HistoricalSitesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.element_list, container, false);

        // Array of elements that will be displayed in the list
        final ArrayList<Element> elements = new ArrayList<Element>();
        elements.add(new Element(
                getString(R.string.peasant_museum),
                getString(R.string.peasant_museum_address),
                R.drawable.muzeul_taranului,
                44.454383,26.083678,
                R.string.peasant_museum_description));
        elements.add(new Element(
                getString(R.string.mogosoaia_palace),
                getString(R.string.mogosoaia_palace_address),
                R.drawable.palatul_mogosoaia,
                44.5277541,25.9925301,
                R.string.mogosoaia_palace_description));
        elements.add(new Element(
                getString(R.string.romanian_athenaeum),
                getString(R.string.romanian_athenaeum_address),
                R.drawable.ateneul_roman,
                44.441286,26.097197,
                R.string.romanian_athenaeum_description));
        elements.add(new Element(
                getString(R.string.cec_palace),
                getString(R.string.cec_palace_address),
                R.drawable.palatul_cec,
                44.432,26.0965,
                R.string.cec_palace_description));

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
