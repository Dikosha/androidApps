package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mainTV;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnPlus, btnMinus, btnDivide, btnMultiple, btnPercent, btnEqual, btnClear;
    private int firstNumber, secondNumber, eventCase;
    private String result = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTV = findViewById(R.id.mainTextView);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiple = findViewById(R.id.btnMultiple);
        btnPercent = findViewById(R.id.btnPercent);
        btnEqual = findViewById(R.id.btnEqual);
        btnClear = findViewById(R.id.btnClear);

        btn0.setOnClickListener( this);
        btn1.setOnClickListener( this);
        btn2.setOnClickListener( this);
        btn3.setOnClickListener( this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener( this);
        btn6.setOnClickListener( this);
        btn7.setOnClickListener( this);
        btn8.setOnClickListener( this);
        btn9.setOnClickListener( this);
        btnPlus.setOnClickListener( this);
        btnPlus.setOnClickListener( this);
        btnMinus.setOnClickListener( this);
        btnDivide.setOnClickListener( this);
        btnMultiple.setOnClickListener( this);
        btnPercent.setOnClickListener( this);
        btnEqual.setOnClickListener( this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn0:
                result += 0;
                break;
            case R.id.btn1:
                result += 1;
                break;
            case R.id.btn2:
                result += 2;
                break;
            case R.id.btn3:
                result += 3;
                break;
            case R.id.btn4:
                result += 4;
                break;
            case R.id.btn5:
                result += 5;
                break;
            case R.id.btn6:
                result += 6;
                break;
            case R.id.btn7:
                result += 7;
                break;
            case R.id.btn8:
                result += 8;
                break;
            case R.id.btn9:
                result += 9;
                break;
            case R.id.btnClear:
                result = "0";
                break;
            case R.id.btnPlus:
                firstNumber = Integer.parseInt(result);
                result = "0";
                eventCase = 1;
                break;
            case R.id.btnMinus:
                firstNumber = Integer.parseInt(result);
                result = "0";
                eventCase = 2;
                break;
            case R.id.btnMultiple:
                firstNumber = Integer.parseInt(result);
                result = "0";
                eventCase = 3;
                break;
            case R.id.btnDivide:
                firstNumber = Integer.parseInt(result);
                result = "0";
                eventCase = 4;
                break;
            case R.id.btnPercent:
                try{
                    result = String.valueOf(Integer.parseInt(result) * 0.01);
                }catch (Exception e){
                    result = String.valueOf(Double.parseDouble(result) * 0.01);
                }
                break;
            case R.id.btnEqual:
                secondNumber = Integer.parseInt(result);
                if(eventCase == 1){
                    result = String.valueOf(firstNumber + secondNumber);
                }else if(eventCase == 2){
                    result = String.valueOf(firstNumber - secondNumber);
                }else if(eventCase == 3){
                    result = String.valueOf(firstNumber * secondNumber);
                }else if(eventCase == 4){
                    if(secondNumber == 0){
                        result = "Nan";
                    }else{
                        result = String.valueOf(Double.parseDouble(String.valueOf(firstNumber)) / Double.parseDouble(String.valueOf(secondNumber)));
                    }
                }
                eventCase = 0;
                break;

        }
        try{
            result = String.valueOf(Integer.parseInt(result));
        }catch (Exception e){
            result = String.valueOf(Double.parseDouble(result));
        }
        mainTV.setText(result);


    }
}