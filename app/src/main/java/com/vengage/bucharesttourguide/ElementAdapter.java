package com.vengage.bucharesttourguide;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.resource;


/**
 * Created by Vengage on 6/21/2017.
 *
 * ArrayAdapter to fill the custom list view with data from the Element object
 */

class ElementAdapter extends ArrayAdapter<Element> {

    ElementAdapter(@NonNull Context context, @NonNull ArrayList<Element> elements) {
        super(context, 0, elements);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Element element = getItem(position);

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        TextView subtitleTextView = (TextView) listItemView.findViewById(R.id.subtitle_text_view);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.item_image_view);

        titleTextView.setText(element.getmTitle());
        subtitleTextView.setText(element.getmAddress());
        imageView.setImageResource(element.getmImageId());

        return listItemView;
    }
}
