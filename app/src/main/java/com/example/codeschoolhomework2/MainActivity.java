package com.example.codeschoolhomework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    private int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickOnButtons(View view) {
                Toast.makeText(getApplicationContext(), "hello its "+ ((Button)view).getText(), Toast.LENGTH_SHORT).show();
    }
}