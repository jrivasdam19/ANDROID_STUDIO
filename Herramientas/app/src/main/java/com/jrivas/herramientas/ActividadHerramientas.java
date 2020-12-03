package com.jrivas.herramientas;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentTransaction; de nuevo lo mismo de antes
//import androidx.fragment.app.FragmentManager; este es el import que no toca #1
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class ActividadHerramientas extends AppCompatActivity implements ComunicaMenu {
Fragment[]misFragmentos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_herramientas);
//array con los fragmentos alojados dentro
        misFragmentos=new Fragment[3];
        misFragmentos[0]=new Linterna();
        misFragmentos[1]=new Musica();
        misFragmentos[2]=new Nivel();

        //rescatamos la información del Bundle
        Bundle extras=getIntent().getExtras();
        //pasarle la inf al método menú para que la actividad sepa cual fragmento
        //ha sido pulsado
        menu(extras.getInt("BOTONPULSADO"));
    }

    @Override
    public void menu(int queBoton){
        //marca error porque busca un paquete y requiere otro #1
        FragmentManager miManejador =getFragmentManager();
        FragmentTransaction miTransaccion=miManejador.beginTransaction();
        //en el segundo argumento puedo meterle cualquiera de los tres fragmentos que queremos visualizar
        //tiene que variar dependiendo del boton pulsado
        miTransaccion.replace(R.id.herramientas,misFragmentos[queBoton]);
        //pàra que comience la tarea sincronizadamente
        miTransaccion.commit();
    }
}