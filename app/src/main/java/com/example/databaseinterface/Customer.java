package com.example.databaseinterface;

import java.io.Serializable;

public class Customer implements Serializable {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private String contactName;
    private String telephoneNumber;

    public Customer() {}

    public Customer(String customerName, String customerAddress, String contactName, String telephoneNumber) {

        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.contactName = contactName;
        this.telephoneNumber = telephoneNumber;
    }


    public Customer(int customerId, String customerName, String customerAddress, String contactName, String telephoneNumber) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.contactName = contactName;
        this.telephoneNumber = telephoneNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
