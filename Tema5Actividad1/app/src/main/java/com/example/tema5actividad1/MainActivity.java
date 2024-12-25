package com.example.tema5actividad1;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }

    public void pulsarBoton1(View view){
        Toast.makeText(this, "Has pulsado Mostrar", Toast.LENGTH_SHORT).show();
    }

    public void pulsarBoton2(View view){
        Toast.makeText(this, "Has pulsado Enseñar", Toast.LENGTH_SHORT).show();
    }
}