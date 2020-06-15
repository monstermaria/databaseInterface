package com.example.databaseinterface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomerArrayAdapter extends ArrayAdapter<Customer> {

    public CustomerArrayAdapter(@NonNull Context context, @NonNull List<Customer> objects) {
        super(context, 0, objects);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Customer customer = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    android.R.layout.simple_list_item_1,
                    parent,
                    false
            );
        }
        // Lookup view for data population
        TextView tvName = convertView.findViewById(android.R.id.text1);
        // Populate the data into the template view using the data object
        if (customer != null) {
            tvName.setText(customer.getCustomerName());
        }
        // Return the completed view to render on screen
        return convertView;
    }
}
