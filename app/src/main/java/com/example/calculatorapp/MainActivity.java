package com.example.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultTextView;
    private double n1, n2;
    private String op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        Button zero= findViewById(R.id.zero);
        zero.setOnClickListener(this);

        Button one = findViewById(R.id.one);
        one.setOnClickListener(this);

        Button two = findViewById(R.id.two);
        two.setOnClickListener(this);

        Button three = findViewById(R.id.three);
        three.setOnClickListener(this);

        Button four= findViewById(R.id.four);
        four.setOnClickListener(this);

        Button five = findViewById(R.id.five);
        five.setOnClickListener(this);

        Button six = findViewById(R.id.six);
        six.setOnClickListener(this);

        Button seven = findViewById(R.id.seven);
        seven.setOnClickListener(this);

        Button eight = findViewById(R.id.eight);
        eight.setOnClickListener(this);

        Button nine= findViewById(R.id.nine);
        nine.setOnClickListener(this);

        Button ADD = findViewById(R.id.add);
        ADD.setOnClickListener(this);

        Button SUB = findViewById(R.id.minus);
        SUB.setOnClickListener(this);

        Button STAR = findViewById(R.id.star);
        STAR.setOnClickListener(this);

        Button DIVIDE = findViewById(R.id.divide);
        DIVIDE.setOnClickListener(this);

        Button EQUALS = findViewById(R.id.equal);
        EQUALS.setOnClickListener(this);

        Button CLEAR = findViewById(R.id.clear);
        CLEAR.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.zero:
                appendNumber("0");
                break;
            case R.id.one:
                appendNumber("1");
                break;
            case R.id.two:
                appendNumber("2");
                break;
            case R.id.three:
                appendNumber("3");
                break;
            case R.id.four:
                appendNumber("4");
                break;
            case R.id.five:
                appendNumber("5");
                break;
            case R.id.six:
                appendNumber("6");
                break;
            case R.id.seven:
                appendNumber("7");
                break;
            case R.id.eight:
                appendNumber("8");
                break;
            case R.id.nine:
                appendNumber("9");
                break;
            case R.id.add:
                setOperator("+");
                break;
            case R.id.minus:
                setOperator("-");
                break;
            case R.id.star:
                setOperator("*");
                break;
            case R.id.divide:
                setOperator("/");
                break;
            case R.id.equal:
                calculateResult();
                break;
            case R.id.clear:
                clearCalculator();
                break;
        }
    }

    private void appendNumber(String number) {
        String currentText = resultTextView.getText().toString();
        String newText = currentText + number;
        resultTextView.setText(newText);
    }

    private void setOperator(String opp) {
        n1 = Double.parseDouble(resultTextView.getText().toString());
        op = opp;
        resultTextView.setText("");
    }

    private void calculateResult() {
        n2 = Double.parseDouble(resultTextView.getText().toString());
        double result = 0.0;
        switch (op) {
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                if (n2 != 0) {
                    result = n1 / n2;
                } else {
                    result = Double.NaN; // Handle division by zero
                }
                break;
        }

        resultTextView.setText(String.valueOf(result));
    }

    private void clearCalculator() {
        resultTextView.setText("");
        n1 = 0.0;
        n2 = 0.0;
        op = "";
    }
}
