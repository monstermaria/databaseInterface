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
            v.setText(String.valueOf(customer.getCustomerId()));

            v = findViewById(R.id.customerNameView);
            v.setText(customer.getCustomerName());

            v = findViewById(R.id.customerAddressView);
            v.setText(customer.getCustomerAddress());

            v = findViewById(R.id.contactNameView);
            v.setText(customer.getContactName());

            v = findViewById(R.id.telephoneNumberView);
            v.setText(customer.getTelephoneNumber());
        }
    }
}