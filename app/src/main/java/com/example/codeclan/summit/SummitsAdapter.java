package com.example.codeclan.summit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sophiemullins on 06/01/2018.
 */

public class SummitsAdapter extends ArrayAdapter<Summit> {

    public SummitsAdapter(Context context, ArrayList<Summit> summits) {
        super(context, 0, summits);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.summit_item, parent, false);
        }
        Summit currentSummit = getItem(position);

        TextView name = (TextView) listItemView.findViewById(R.id.name);
        name.setText(currentSummit.getName());

        TextView height =  (TextView) listItemView.findViewById(R.id.height);
        height.setText(currentSummit.getHeight().toString());

        TextView range = (TextView) listItemView.findViewById(R.id.range);
        range.setText(currentSummit.getRange());

        TextView country = (TextView) listItemView.findViewById(R.id.country);
        country.setText(currentSummit.getRange());

        listItemView.setTag(currentSummit);

        return listItemView;
    }
}

