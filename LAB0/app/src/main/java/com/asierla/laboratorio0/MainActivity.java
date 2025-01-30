package com.asierla.laboratorio0;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int contador = 0; // Contador inicial

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Crear un LinearLayout como contenedor
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        // Crear un TextView para mostrar el contador
        TextView contadorTexto = new TextView(this);
        contadorTexto.setText("Contador: " + contador);
        contadorTexto.setTextSize(24); // Tamaño de texto más grande
        layout.addView(contadorTexto); // Agregar el TextView al layout

        // Crear un botón para incrementar el contador
        Button boton = new Button(this);
        boton.setText("Incrementar");
        layout.addView(boton); // Agregar el botón al layout

        // Establecer un listener para el botón
        boton.setOnClickListener(v -> {
            contador++; // Incrementar el contador
            contadorTexto.setText("Contador: " + contador); // Actualizar el TextView
        });

        // Establecer el LinearLayout como la vista principal
        setContentView(layout);
    }
}
