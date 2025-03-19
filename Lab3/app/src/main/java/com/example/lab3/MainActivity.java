package com.example.lab3;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        result = findViewById(R.id.result);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void displayResult(String text) {
        result.setText("Result: " + text);
    }

    public void add(View v) {
        if (!num1.getText().toString().isEmpty() && !num2.getText().toString().isEmpty()) {
            Float number1 = Float.parseFloat(num1.getText().toString());
            Float number2 = Float.parseFloat(num2.getText().toString());
            displayResult(String.valueOf(number1 + number2));
        } else {
            displayResult("Invalid Input");
        }
    }

    public void subtract(View v) {
        if (!num1.getText().toString().isEmpty() && !num2.getText().toString().isEmpty()) {
            Float number1 = Float.parseFloat(num1.getText().toString());
            Float number2 = Float.parseFloat(num2.getText().toString());
            displayResult(String.valueOf(number1 - number2));
        } else {
            displayResult("Invalid Input");
        }
    }

    public void multiply(View v) {
        if (!num1.getText().toString().isEmpty() && !num2.getText().toString().isEmpty()) {
            Float number1 = Float.parseFloat(num1.getText().toString());
            Float number2 = Float.parseFloat(num2.getText().toString());
            displayResult(String.valueOf(number1 * number2));
        } else {
            displayResult("Invalid Input");
        }
    }

    public void divide(View v) {
        if (!num1.getText().toString().isEmpty() && !num2.getText().toString().isEmpty()) {
            Float number1 = Float.parseFloat(num1.getText().toString());
            Float number2 = Float.parseFloat(num2.getText().toString());
            displayResult(String.valueOf(number1 / number2));
        } else {
            displayResult("Invalid Input");
        }
    }

}