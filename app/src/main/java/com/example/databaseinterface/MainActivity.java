package com.example.databaseinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    DatabaseHandler dbHandler;
    Cursor customers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("onCreate", this.toString());

        dbHandler = new DatabaseHandler(this);

        dbHandler.addCustomer(new Customer("Företag Ett", "Storgatan 1", "Anna", "123456"));
        dbHandler.addCustomer(new Customer("Företag Två", "Storgatan 2", "Bertil", "234567"));
        dbHandler.addCustomer(new Customer("Företag Tre", "Storgatan 3", "Cecilia", "345678"));
        dbHandler.addCustomer(new Customer("Företag Fyra", "Storgatan 4", "Diego", "456789"));

        customers = dbHandler.getAllCustomers();

        CustomerCursorAdapter adapter = new CustomerCursorAdapter(this, customers);

        ListView customersView = findViewById(R.id.listView);

        customersView.setAdapter(adapter);
        customersView.setOnItemClickListener(new CustomerOnClick());

        Log.d("Number of customers ", String.valueOf(customers.getCount()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        customers.close();
        dbHandler.close();

        Log.d("onDestroy", "Closing resources");
    }

    private static class CustomerOnClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView parent, View v, int position, long id) {

            Log.d("CustomerOnClick pos", String.valueOf(position));
            Log.d("CustomerOnClick id", String.valueOf(id));

            // find out current visibility
            CustomerCursorAdapter adapter = (CustomerCursorAdapter) parent.getAdapter();
            boolean showDetails = adapter.showDetails[position];

            Log.d("Customer show before", String.valueOf(adapter.showDetails[position]));

            // change visibility
            View details = v.findViewById(R.id.details);

            if (showDetails) {
                // hide details
                details.setVisibility(View.GONE);
                // update visibility array
                adapter.showDetails[position] = false;
            } else {
                // show details
                details.setVisibility(View.VISIBLE);
                // update visibility array
                adapter.showDetails[position] = true;
            }

            Log.d("Customer show after", String.valueOf(adapter.showDetails[position]));
        }
    }
}
