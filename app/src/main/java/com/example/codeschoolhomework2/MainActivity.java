package com.example.codeschoolhomework2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnZero;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnDot;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnEqual;
    private Button btnDivide;
    private Button btnMultiply;
    private TextView tvCalculator;
    private OperationType operationType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCalculator = findViewById(R.id.calculatorTV);
    }

    @SuppressLint("SetTextI18n")
    public void onNumberButtonClick(View view) {
        //Toast.makeText(getApplicationContext(), "hello its " + ((Button) view).getText(), Toast.LENGTH_SHORT).show();
        tvCalculator.setText(tvCalculator.getText().toString() + ((Button) view).getText());
    }

    public void onRemoveButton(View view) {
        try {
            if (!tvCalculator.getText().toString().isEmpty()) {
                String calcText = tvCalculator.getText().toString();
                Log.e("CalText", calcText);
                calcText = calcText.substring(0, calcText.length() - 1);
                tvCalculator.setText(calcText);
            } else if (tvCalculator.getText().toString().isEmpty())
                Toast.makeText(this, "Its Empty", Toast.LENGTH_SHORT).show();
        } catch (StringIndexOutOfBoundsException e) {
            Log.e("Exception", "String Index is out of bounds");
        }
    }

    @SuppressLint("SetTextI18n")
    public void plusNumbers(View view) {
        tvCalculator.setText(tvCalculator.getText().toString() + ((Button) view).getText());
        int a = Integer.parseInt(String.valueOf(tvCalculator.getText().charAt(0)));
        int b = Integer.parseInt(String.valueOf(tvCalculator.getText().charAt(2)));
        Log.e("Sum", String.valueOf(a));
        Log.e("Sum", String.valueOf(b));
    }

    public void onPlusButtonClick(View view) {
        operationType = OperationType.PLUS;
        tvCalculator.setText(tvCalculator.getText().toString() + ((Button) view).getText());
    }

    public void onMinusButtonClick(View view) {
        operationType = OperationType.MINUS;
        tvCalculator.setText(tvCalculator.getText().toString() + ((Button) view).getText());
    }

    public void onMultiplyButtonClick(View view) {
        operationType = OperationType.MULTIPLY;
        tvCalculator.setText(tvCalculator.getText().toString() + ((Button) view).getText());
    }

    public void onDivideButtonClick(View view) {
        operationType = OperationType.DIVIDE;
        tvCalculator.setText(tvCalculator.getText().toString() + ((Button) view).getText());
    }
    public void  onEqualButtonClick(View view){
        int a = Integer.parseInt(String.valueOf(tvCalculator.getText().charAt(0)));
        int b = Integer.parseInt(String.valueOf(tvCalculator.getText().charAt(2)));
        Log.e("Operation ", String.valueOf(operationType.calculate(a,b)));
        tvCalculator.setText(String.valueOf(operationType.calculate(a,b)));

    }


}