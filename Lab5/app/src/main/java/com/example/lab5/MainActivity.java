package com.example.lab5;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup radiogrp;
    RadioButton r1, r2, r3;
    CheckBox check1, check2, check3;
    TextView feedback1, feedback2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        radiogrp = findViewById(R.id.radiogrp);
        r1 = findViewById(R.id.rb1);
        r2 = findViewById(R.id.rb2);
        r3 = findViewById(R.id.rb3);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        feedback1 = findViewById(R.id.feedback1);
        feedback2 = findViewById(R.id.feedback2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void disableFirst() {
        r1.setEnabled(false);
        r2.setEnabled(false);
        r3.setEnabled(false);
    }

    public void disableSecond() {
        check1.setEnabled(false);
        check2.setEnabled(false);
        check3.setEnabled(false);
    }

    public void submitFirst(View v) {

        int selectedId = radiogrp.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            String selectedText = selectedRadioButton.getText().toString();

            if (selectedText.equals("Madrid")) {
                selectedRadioButton.setTextColor(Color.rgb(0, 255, 0));
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
                feedback1.setText("Correct Ans");
                feedback1.setTextColor(Color.rgb(0, 255, 0));
            } else {
                selectedRadioButton.setTextColor(Color.rgb(255, 0, 0));
                Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                feedback1.setText("Wrong Ans");
                feedback1.setTextColor(Color.rgb(255, 0, 0));
            }

            ((Button) v).setEnabled(false);
            disableFirst();

        } else {
            Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();
        }

    }

    public void submitSecond(View v) {

        if (check1.isChecked() || check2.isChecked() || check3.isChecked()) {
            if (check1.isChecked() && check2.isChecked() && !check3.isChecked()) {
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
                feedback2.setText("Correct Ans");
                feedback2.setTextColor(Color.rgb(0, 255, 0));
            } else {
                Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                feedback2.setText("Wrong Ans");
                feedback2.setTextColor(Color.rgb(255, 0, 0));
            }

            check1.setTextColor(Color.rgb(0, 255, 0));
            check2.setTextColor(Color.rgb(0, 255, 0));
            check3.setTextColor(Color.rgb(255, 0, 0));

            ((Button) v).setEnabled(false);
            disableSecond();

        } else {
            Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();
        }


    }

}