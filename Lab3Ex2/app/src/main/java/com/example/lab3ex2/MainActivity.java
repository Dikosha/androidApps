package com.example.lab3ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    ArrayList<Item> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        arrayList.add(new Item(R.drawable.first, "Arthur Weasley", "father"));
        arrayList.add(new Item(R.drawable.second, "Molly Weasley", "mother"));
        arrayList.add(new Item(R.drawable.third, "Bill Weasley", "brother"));
        arrayList.add(new Item(R.drawable.fourth, "Charlie Weasley", "brother"));
        arrayList.add(new Item(R.drawable.fifth, "Fred Weasley", "brother"));
        arrayList.add(new Item(R.drawable.sixth, "George Weasley", "brother"));

        MyAdapter myAdapter=new MyAdapter(this, R.layout.list_item, arrayList);
        listView.setAdapter(myAdapter);
    }
}