package com.myapplicationdev.android.c302_p08_ps_secured_cloud_address_book2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {

    public static final String LOG_TAG = ContactAdapter.class.getName();

    ArrayList<Contact> alContact;
    Context context;

    public ContactAdapter(Context context, int resource, ArrayList<Contact> objects) {
        super(context, resource, objects);
        alContact = objects;
        this.context = context;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.contact_row, parent, false);

        TextView tvName = (TextView) rowView.findViewById(R.id.tvName);
        TextView tvMobile = (TextView) rowView.findViewById(R.id.tvMobile);

        Contact contact = alContact.get(position);

        tvName.setText(contact.getFirstName() + " " + contact.getLastName());
        tvMobile.setText(contact.getMobile());

        return rowView;
    }

}