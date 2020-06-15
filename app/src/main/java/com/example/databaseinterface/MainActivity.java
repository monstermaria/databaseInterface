package com.example.databaseinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("onCreate", this.toString());

        DatabaseHandler dbHandler = new DatabaseHandler(this);

        dbHandler.addCustomer(new Customer("Ett", "Gatan 1", "A", "123456"));
        dbHandler.addCustomer(new Customer("Två", "Gatan 2", "B", "234567"));
        dbHandler.addCustomer(new Customer("Tre", "Gatan 3", "C", "345678"));

        ArrayList<Customer> customers = dbHandler.getAllCustomers();

        CustomerArrayAdapter adapter = new CustomerArrayAdapter(this, customers);
        ListView customersView = findViewById(R.id.listView);
        customersView.setAdapter(adapter);
        customersView.setOnItemClickListener(new CustomerOnClick());

        Log.d("Number of customers ", String.valueOf(customers.size()));
    }

    private class CustomerOnClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView parent, View v, int position, long id) {

            Log.d("CustomerOnClick", String.valueOf(position));

            Customer customer = (Customer) parent.getItemAtPosition(position);

            Intent intent = new Intent(parent.getContext(), ShowCustomerActivity.class);
            intent.putExtra("customer", customer);

            startActivity(intent);
        }
    }
}
