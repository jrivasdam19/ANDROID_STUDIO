package com.jrivas.herramientas;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Menu extends Fragment {
    private final int[] BOTONES_MENU = {R.id.linterna, R.id.musica, R.id.nivel};

    public Menu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View miMenu = inflater.inflate(R.layout.fragment_menu, container, false);

        ImageButton botonMenu;

        for (int i = 0; i < BOTONES_MENU.length; i++) {
            botonMenu=(ImageButton)miMenu.findViewById(BOTONES_MENU[i]);
            final int queBoton=i;
            botonMenu.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    //nos dirá en qué actividad estamos cuando pulsamos el botón
                    Activity estaActividad=getActivity();
                    //nos da error en un principio porque no corresponden los tipos
                    //por tanto hacemos un casting, le pasamos a la interfaz qué botón pulsamos
                    ((ComunicaMenu)estaActividad).menu(queBoton);
                }
            });
        }
         return miMenu;
    }
}