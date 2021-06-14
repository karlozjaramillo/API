package com.cj.api;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cj.api.models.Location;

import java.util.List;

public class LocationAdapter extends BaseAdapter {

    protected Activity activity;
    protected List<Location> myLocations;

    public LocationAdapter(Activity activity, List<Location> myLocations) {
        this.activity = activity;
        this.myLocations = myLocations;
    }

    @Override
    public int getCount() {
        return myLocations.size();
    }

    @Override
    public Object getItem(int position) {
        return myLocations.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.location_item, null);
        }
        Location location = myLocations.get(position);
        TextView nameLocation = view.findViewById(R.id.tvNameLocation);
        TextView typeLocation = view.findViewById(R.id.tvType);
        TextView dimensionLocation = view.findViewById(R.id.tvDimension);
        TextView createdLocation = view.findViewById(R.id.tvCreatedLocation);

        nameLocation.setText(location.getNameLocation());
        typeLocation.setText("Type: " + location.getTypeLocation());
        dimensionLocation.setText("Dimension: " + location.getDimensionLocation());
        createdLocation.setText("Created: " + location.getCreatedLocation());

        return view;
    }
}
