package com.jrivas.herramientas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ComunicaMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void menu(int queBoton) {
        Intent in = new Intent(this, ActividadHerramientas.class);
        //cargamos dentro de ese intento la información que queremos pasar
        //lo hacemos con un Bundle, .putExtra(nombre identificativo para el Bundle, donde está almacenada esa inf)
        in.putExtra("BOTONPULSADO",queBoton);
        startActivity(in);
    }
}