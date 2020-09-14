package com.example.coffeeordering;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxCream, checkBoxChocolate;
    private Button buttonPlus, buttonMinus, buttonOrder;
    private TextView textViewQuantity, textViewSummary;
    private double price = 0;
    private int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBoxCream = findViewById(R.id.checkBoxCream);
        checkBoxChocolate = findViewById(R.id.checkBoxChocolate);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonOrder = findViewById(R.id.buttonOrder);
        textViewQuantity = findViewById(R.id.textViewQuantity);
        textViewSummary = findViewById(R.id.textViewSummary);

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                quantity += 1;

                textViewQuantity.setText(String.valueOf(quantity));
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                quantity -= 1;
                if(quantity < 0){
                    quantity = 0;
                }
                textViewQuantity.setText(String.valueOf(quantity));
            }
        });

        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String order = "";
                price = 0;
                order += "Add whipped cream? ";
                if(checkBoxCream.isChecked()){
                    order += "no\n";
                }else{
                    order += "yes\n";
                    price = 0.5;
                }

                order += "Add chocolate? ";
                if(checkBoxChocolate.isChecked()){
                    order += "no\n";
                }else{
                    order += "yes\n";
                    price += 1;
                }
                order += "Quantity: " + quantity + "\n\n";
                if(quantity != 0) {
                    price = quantity * (4 + price);
                }
                order += "Price: $" + price + "\n";
                order += "THANK YOU!";
                textViewSummary.setText(order);
            }
        });
    }
}