package com.example.databaseinterface;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE = "example_database";
    private static final String TABLE = "customers";
    private static final String KEY_CUSTOMER_ID = "CustomerID";
    private static final String KEY_CUSTOMER_NAME = "CustomerName";
    private static final String KEY_CUSTOMER_ADDRESS = "CustomerAddress";
    private static final String KEY_CONTACT_NAME = "ContactName";
    private static final String KEY_PHONE_NUMBER = "PhoneNumber";

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createCustomersTable = "CREATE TABLE " + TABLE + " ("
                + KEY_CUSTOMER_ID + " INTEGER PRIMARY KEY, "
                + KEY_CUSTOMER_NAME + " TEXT, "
                + KEY_CUSTOMER_ADDRESS + " TEXT, "
                + KEY_CONTACT_NAME + " TEXT, "
                + KEY_PHONE_NUMBER + " TEXT);";

        Log.d("create table", createCustomersTable);

        db.execSQL(createCustomersTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE);

        onCreate(db);
    }

    void addCustomer(Customer customer) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CUSTOMER_NAME, customer.getCustomerName());
        values.put(KEY_CUSTOMER_ADDRESS, customer.getCustomerAddress());
        values.put(KEY_CONTACT_NAME, customer.getContactName());
        values.put(KEY_PHONE_NUMBER, customer.getTelephoneNumber());

        db.insert(TABLE, null, values);
        db.close();
    }

    Customer getCustomer(int id) {

        Customer customer = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String[] COLUMNS = {KEY_CUSTOMER_ID, KEY_CUSTOMER_NAME, KEY_CUSTOMER_ADDRESS, KEY_CONTACT_NAME, KEY_PHONE_NUMBER};
        String SELECTION = KEY_CUSTOMER_ID + "=?";
        String[] SELECTION_ARGS = {String.valueOf(id)};

        Cursor cursor = db.query(TABLE, COLUMNS, SELECTION, SELECTION_ARGS, null, null, null);

        if (cursor.moveToFirst()) {
            customer = getCustomerObjectFromCursor(cursor);
        }

        cursor.close();
        db.close();

        return customer;
    }

    ArrayList<Customer> getAllCustomers() {

        ArrayList<Customer> customers = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE, null);

        while (cursor.moveToNext()) {
            customers.add(getCustomerObjectFromCursor(cursor));
        }

        cursor.close();
        db.close();

        return customers;
    }

    Customer getCustomerObjectFromCursor(Cursor cursor) {

        return new Customer(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4)
        );
    }
}
