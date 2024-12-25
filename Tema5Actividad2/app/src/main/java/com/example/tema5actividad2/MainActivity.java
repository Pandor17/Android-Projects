package com.example.tema5actividad2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

    }

    public void modificarTextWiew(View wiew){
        if (!editText.getText().toString().trim().isEmpty()) { //trim: método para eliminar espacios en blanco
            textView.setText(editText.getText());
        }
        else{
            Toast.makeText(this, "No has escrito nada", Toast.LENGTH_SHORT).show();
        }
    }
}