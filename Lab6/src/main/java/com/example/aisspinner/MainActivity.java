package com.example.aisspinner;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    Button pickDateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.dropdown);

        String[] spinnerItems = {"--- Select an Option ---", "Item 1", "Item 2", "Item 3", "Item 4"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.cutom_spinner_selected_item, spinnerItems);
        adapter.setDropDownViewResource(R.layout.custom_spinner_item);

        spinner.setAdapter(adapter);
        spinner.setSelection(0);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view, int position, long id) {

                View selectedItemView = spinner.getSelectedView();
                TextView selectedTextView = (TextView) selectedItemView;

                if (position == 0) {
                    selectedTextView.setTextColor(Color.rgb(0, 0, 0));
                    this.onNothingSelected(parentView);
                } else {
                    selectedTextView.setTextColor(Color.rgb(0,255, 0));
                    Toast.makeText(MainActivity.this, "Selected: " + spinnerItems[position], Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(MainActivity.this, "Nothing is selected", Toast.LENGTH_SHORT).show();
            }
        });

        pickDateBtn = findViewById(R.id.pickDateBtn);

        pickDateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        R.style.SpinnerDatePickerDialog,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                Toast.makeText(MainActivity.this, "" + dayOfMonth + "/" + (month + 1) + "/" + year, Toast.LENGTH_SHORT).show();

                            }
                        },
                        year, month, dayOfMonth
                );
                dialog.show();

            }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}