package com.example.databaseinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowCustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_customer);

        TextView v;
        Customer customer = (Customer) getIntent().getSerializableExtra("customer");

        if (customer != null) {

            v = findViewById(R.id.customerIdView);
            v.setText(getString(R.string.customer_id, customer.getCustomerId()));

            v = findViewById(R.id.customerNameView);
            v.setText(getString(R.string.customer_name, customer.getCustomerName()));

            v = findViewById(R.id.customerAddressView);
            v.setText(getString(R.string.customer_address, customer.getCustomerAddress()));

            v = findViewById(R.id.contactNameView);
            v.setText(getString(R.string.contact_name, customer.getContactName()));

            v = findViewById(R.id.telephoneNumberView);
            v.setText(getString(R.string.telephone_number, customer.getTelephoneNumber()));
        }
    }
}