package com.myapplicationdev.android.c302_p08_ps_secured_cloud_address_book2;

import java.io.Serializable;

public class Contact implements Serializable {

    private int contactId;
    private String firstName, lastName, mobile;

    public Contact(int contactId, String firstName, String lastName, String mobile) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}