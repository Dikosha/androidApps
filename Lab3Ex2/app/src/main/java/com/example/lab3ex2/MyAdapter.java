package com.example.lab3ex2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Item> {

    ArrayList<Item> items = new ArrayList<>();
    public MyAdapter(@NonNull Context context, int resource, ArrayList<Item> objects) {
        super(context, resource, objects);
        items = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("MyLOG: ", "1234567");
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_item, null);
        TextView textViewName = (TextView) v.findViewById(R.id.textViewName);
        TextView textViewSibling = (TextView) v.findViewById(R.id.textViewSibling);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        textViewName.setText(items.get(position).getName());
        textViewSibling.setText(items.get(position).getSibling());
        imageView.setImageResource(items.get(position).getImage());
        return v;
    }
}
