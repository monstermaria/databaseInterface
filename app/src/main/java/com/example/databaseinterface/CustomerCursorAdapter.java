package com.example.databaseinterface;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomerCursorAdapter extends CursorAdapter {

    // array to keep track of which rows to show details for
    boolean[] showDetails;

    public CustomerCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);

        // initiate visibility of details to false
        showDetails = new boolean[c.getCount()];
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        // inflate a view from a layout resource and return it
        return LayoutInflater.from(context).inflate(R.layout.customer, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // set visibility of details
        View details = view.findViewById(R.id.details);
        int position = cursor.getPosition();

        Log.d("Customer bindView", position + " " + showDetails[position]);

        if (showDetails[position]) {
            details.setVisibility(View.VISIBLE);
        } else {
            details.setVisibility(View.GONE);
        }

        // populate views with data from the cursor
        TextView textView;

        textView = (TextView) view.findViewById(R.id.id);
        textView.setText(context.getString(R.string.customer_id, cursor.getString(0)));

        textView = (TextView) view.findViewById(R.id.name);
        textView.setText(context.getString(R.string.customer_name, cursor.getString(1)));

        textView = (TextView) view.findViewById(R.id.address);
        textView.setText(context.getString(R.string.customer_address, cursor.getString(2)));

        textView = (TextView) view.findViewById(R.id.contact);
        textView.setText(context.getString(R.string.contact_name, cursor.getString(3)));

        textView = (TextView) view.findViewById(R.id.telephone);
        textView.setText(context.getString(R.string.telephone_number, cursor.getString(4)));
    }
}
