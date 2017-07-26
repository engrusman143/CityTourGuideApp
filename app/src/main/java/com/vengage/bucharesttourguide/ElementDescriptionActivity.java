package com.vengage.bucharesttourguide;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

/**
 * Activity which presents the description of an Element
 *
 *
 */
public class ElementDescriptionActivity extends AppCompatActivity {

    private static final String TAG = "ElementDescriptionActiv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get the element from the intent
        final Element element = getIntent().getExtras().getParcelable("element");

        // Set the title of the activity using the element name
        setTitle(element.getmTitle());

        // Set the image of the element in the toolbar
        ImageView imageView = (ImageView) findViewById(R.id.image_id);
        imageView.setImageResource(element.getmImageId());

        // Display the description of the element
        TextView descriTextView = (TextView) findViewById(R.id.description_text_view);
        descriTextView.setText(getString(element.getmDescriptionID()));

        // Send the user into Google Maps to the corresponding element location
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to Google Maps to the location of the element
                String string = getString(
                        R.string.geolocation_1,
                        String.valueOf(element.getmLatitude()),
                        String.valueOf(element.getmLongitude()),
                        String.valueOf(element.getmLatitude()),
                        String.valueOf(element.getmLongitude()));
                Log.i(TAG, string);
                Uri uri = Uri.parse(string);
                Log.i(TAG, uri.toString());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}
