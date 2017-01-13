package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



/**
 * Created by Plop on 10/01/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }
        Earthquake currentEarthquakeItem = getItem(position);

        String fullLocation = currentEarthquakeItem.getmPlace();
        int pos;
        String locationOffset;
        String primaryLocation;
        if ((pos = fullLocation.indexOf("of")) != -1) {
            locationOffset = fullLocation.substring(0, pos + 2);
            primaryLocation = fullLocation.substring(pos + 3, fullLocation.length());
        } else {
            locationOffset = "Near the";///
            primaryLocation = fullLocation;
        }
        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffsetTextView.setText(locationOffset);
        TextView primaryLocationTextView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryLocationTextView.setText(primaryLocation);


        DecimalFormat formatter = new DecimalFormat("0.0");
        String strMagnitude = formatter.format(currentEarthquakeItem.getmMagnitude());
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeTextView.setText(strMagnitude);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquakeItem.getmMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        Date dateObject = new Date(currentEarthquakeItem.getmTimeInMilliseconds());
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyy");
        String formattedDate = dateFormatter.format(dateObject);
        dateTextView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String formattedTime = timeFormat.format(dateObject);
        timeView.setText(formattedTime);

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
