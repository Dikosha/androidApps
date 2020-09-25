package com.example.shippingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView baseCostTV, addedCostTv, totalCostTV;
    private int ounces = 0;
    private double baseCost = 0;
    private double addedCost = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextNumber);
        String res = "";
        baseCostTV = findViewById(R.id.baseCostTextView);
        addedCostTv = findViewById(R.id.addedCostTextView);
        totalCostTV = findViewById(R.id.totalCostTextView);
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(String.valueOf(editText.getText()).compareTo("") != 0) {
                    ounces = Integer.parseInt(String.valueOf(editText.getText()));
                    Log.d("MyLOG", String.valueOf(ounces));
                    if (ounces > 30) {
                        baseCost = 4;
                        addedCost = Math.ceil(Double.parseDouble(String.valueOf((ounces - 30))) / 16) * 0.5;
                        Log.d("MyLOG", "addedCost: " + Double.parseDouble(String.valueOf((ounces - 30))) / 16);
                    }else{
                        baseCost = 3;
                    }

                }else{
                    baseCost = 0;
                    addedCost = 0;
                }
                baseCostTV.setText(baseCost + "$");
                addedCostTv.setText(addedCost + "$");
                totalCostTV.setText(String.valueOf(baseCost+ addedCost) + "$");
            }
        });
    }
}