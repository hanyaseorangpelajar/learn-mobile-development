package com.example.kalkulatorbalok;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String KEY_RESULT = "key_result";
    private TextView tvResult;
    private EditText etWidth;
    private EditText etLength;
    private EditText etHeight;
    private Button btnCalculate;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String calculationResult = tvResult.getText().toString();
        outState.putString(KEY_RESULT, calculationResult);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate_volume) {
            String inputLength = etLength.getText().toString().trim();
            String inputWidth = etWidth.getText().toString().trim();
            String inputHeight = etHeight.getText().toString().trim();
            boolean isEmptyFields = false;

            if (inputLength.isEmpty()) {
                isEmptyFields = true;
                etLength.setError("Field ini tidak boleh kosong");
            }

            if (inputWidth.isEmpty()) {
                isEmptyFields = true;
                etWidth.setError("Field ini tidak boleh kosong");
            }

            if (inputHeight.isEmpty()) {
                isEmptyFields = true;
                etHeight.setError("Field ini tidak boleh kosong");
            }

            if (!isEmptyFields) {
                double volume = Double.parseDouble(inputLength) *
                        Double.parseDouble(inputWidth) *
                        Double.parseDouble(inputHeight);
                tvResult.setText(String.format("Volume: %s", String.valueOf(volume)));
            }
        }
    }
    private void calculateSurfaceArea() {
        String inputLength = etLength.getText().toString().trim();
        String inputWidth = etWidth.getText().toString().trim();
        String inputHeight = etHeight.getText().toString().trim();
        boolean isEmptyFields = false;

        if (inputLength.isEmpty()) {
            isEmptyFields = true;
            etLength.setError("Field ini tidak boleh kosong");
        }

        if (inputWidth.isEmpty()) {
            isEmptyFields = true;
            etWidth.setError("Field ini tidak boleh kosong");
        }

        if (inputHeight.isEmpty()) {
            isEmptyFields = true;
            etHeight.setError("Field ini tidak boleh kosong");
        }

        if (!isEmptyFields) {
            double surfaceArea = 2 * (Double.parseDouble(inputLength) * Double.parseDouble(inputWidth) +
                    Double.parseDouble(inputLength) * Double.parseDouble(inputHeight) +
                    Double.parseDouble(inputWidth) * Double.parseDouble(inputHeight));
            tvResult.setText(String.format("Luas Permukaan: %s", String.valueOf(surfaceArea)));
        }
    }

    private void calculatePerimeter() {
        String inputLength = etLength.getText().toString().trim();
        String inputWidth = etWidth.getText().toString().trim();
        String inputHeight = etHeight.getText().toString().trim();
        boolean isEmptyFields = false;

        if (inputLength.isEmpty()) {
            isEmptyFields = true;
            etLength.setError("Field ini tidak boleh kosong");
        }

        if (inputWidth.isEmpty()) {
            isEmptyFields = true;
            etWidth.setError("Field ini tidak boleh kosong");
        }

        if (inputHeight.isEmpty()) {
            isEmptyFields = true;
            etHeight.setError("Field ini tidak boleh kosong");
        }

        if (!isEmptyFields) {
            double perimeter = 4 * (Double.parseDouble(inputLength) + Double.parseDouble(inputWidth) + Double.parseDouble(inputHeight));
            tvResult.setText(String.format("Keliling: %s", String.valueOf(perimeter)));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result);
        etWidth = findViewById(R.id.et_width);
        etLength = findViewById(R.id.et_length);
        etHeight = findViewById(R.id.et_height);
        btnCalculate = findViewById(R.id.btn_calculate_volume);
        Button btnCalculateSurfaceArea = findViewById(R.id.btn_calculate_surface_area);
        Button btnCalculatePerimeter = findViewById(R.id.btn_calculate_perimeter);
        btnCalculate.setOnClickListener(this);

        btnCalculateSurfaceArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateSurfaceArea();
            }
        });

        btnCalculatePerimeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatePerimeter();
            }
        });

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(KEY_RESULT);
            tvResult.setText(result);
        }
    }
}
