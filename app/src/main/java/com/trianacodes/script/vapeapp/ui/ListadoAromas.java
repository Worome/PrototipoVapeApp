package com.trianacodes.script.vapeapp.ui;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import com.trianacodes.script.vapeapp.Adaptadores.AdaptadorRecyclerView;
import com.trianacodes.script.vapeapp.R;
import com.trianacodes.script.vapeapp.sqlite.OperacionesBasesDeDatos;

public class ListadoAromas extends AppCompatActivity {

    private OperacionesBasesDeDatos operacionesDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_aromas);

        RecyclerView recyclerView = findViewById(R.id.rvAromas);
        //Creo un LinearLayoutManager para asociarlo al RecyclerView
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        // Asocio el LinearlayoutManager al RecyclerView
        recyclerView.setLayoutManager(linearLayout);
        //Creo el adaptador
        adaptadorDatos = new AdaptadorRecyclerView(operacionesDatos.obtenerAromas());
        recyclerView.setAdapter(adaptadorDatos);
    }
}
