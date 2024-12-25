package com.example.calculadora;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber1, etNumber2;
    private RadioGroup rgOperations;
    private TextView tvResult;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber1 = findViewById(R.id.et_number1);
        etNumber2 = findViewById(R.id.et_number2);
        rgOperations = findViewById(R.id.rg_operations);
        tvResult = findViewById(R.id.tv_result);

        sharedPreferences = getSharedPreferences("CalculatorPrefs", MODE_PRIVATE);

        findViewById(R.id.btn_calculate).setOnClickListener(this::onCalculate);
        findViewById(R.id.btn_clear).setOnClickListener(this::onClear);
        findViewById(R.id.btn_save).setOnClickListener(this::onSave);
        findViewById(R.id.btn_show).setOnClickListener(this::onShow);
    }

    private void onCalculate(View view) {
        String num1Str = etNumber1.getText().toString();
        String num2Str = etNumber2.getText().toString();

        if (TextUtils.isEmpty(num1Str) || TextUtils.isEmpty(num2Str)) {
            tvResult.setText("Por favor, ingrese ambos números.");
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;

        int selectedOperation = rgOperations.getCheckedRadioButtonId();
        if (selectedOperation == R.id.rb_add) {
            result = num1 + num2;
        } else if (selectedOperation == R.id.rb_subtract) {
            result = num1 - num2;
        } else if (selectedOperation == R.id.rb_multiply) {
            result = num1 * num2;
        } else if (selectedOperation == R.id.rb_divide) {
            if (num2 == 0) {
                tvResult.setText("Error: División por cero.");
                return;
            }
            result = num1 / num2;
        } else {
            tvResult.setText("Seleccione una operación.");
            return;
        }

        tvResult.setText("Resultado: " + result);
    }

    private void onClear(View view) {
        etNumber1.setText("");
        etNumber2.setText("");
        rgOperations.clearCheck();
        tvResult.setText("Resultado: ");
    }

    private void onSave(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("last_result", tvResult.getText().toString());
        editor.apply();
        Toast.makeText(this, "Resultado guardado", Toast.LENGTH_SHORT).show();
    }

    private void onShow(View view) {
        String lastResult = sharedPreferences.getString("last_result", "No hay resultados guardados.");
        tvResult.setText(lastResult);
    }
}