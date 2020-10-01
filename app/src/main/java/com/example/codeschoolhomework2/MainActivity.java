package com.example.codeschoolhomework2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tvCalculator;
    private OperationType operationType;
    private String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCalculator = findViewById(R.id.calculatorTV);
    }

    public void onNumberButtonClick(View view) {
        tvCalculator.setText(String.format("%s%s", tvCalculator.getText().toString(), ((Button) view).getText()));
    }

    public void onRemoveButton(View view) {
        if (!tvCalculator.getText().toString().isEmpty()) {
            String calcText = tvCalculator.getText().toString();
            Log.e("CalText", calcText);
            calcText = calcText.substring(0, calcText.length() - 1);
            tvCalculator.setText(calcText);
        }
        if (tvCalculator.getText().toString().isEmpty() || tvCalculator.getText().length() == 0) {
            Toast.makeText(this, "Its Empty", Toast.LENGTH_SHORT).show();
        }
    }

    public void onPlusButtonClick(View view) {
        operationType = OperationType.PLUS;
        tvCalculator.setText(String.format("%s%s", tvCalculator.getText().toString(), ((Button) view).getText()));
        captureFirstNumber();
    }

    public void onMinusButtonClick(View view) {
        operationType = OperationType.MINUS;
        tvCalculator.setText(String.format("%s%s", tvCalculator.getText().toString(), ((Button) view).getText()));
        captureFirstNumber();
    }

    public void onMultiplyButtonClick(View view) {
        operationType = OperationType.MULTIPLY;
        tvCalculator.setText(String.format("%s%s", tvCalculator.getText().toString(), ((Button) view).getText()));
        captureFirstNumber();
    }

    public void onDivideButtonClick(View view) {
        operationType = OperationType.DIVIDE;
        tvCalculator.setText(String.format("%s%s", tvCalculator.getText().toString(), ((Button) view).getText()));
        captureFirstNumber();
    }

    public void onEqualButtonClick(View view) {
        findSecondNumber();
        tvCalculator.setText(String.valueOf(operationType.calculate(Double.parseDouble(a), Double.parseDouble(findSecondNumber()))));
    }

    private void captureFirstNumber() {
        a = tvCalculator.getText().toString().substring(0, tvCalculator.length() - 1);
    }

    private String findSecondNumber() {
        return tvCalculator.getText().toString().substring(a.length() + 1, tvCalculator.length());
    }


}