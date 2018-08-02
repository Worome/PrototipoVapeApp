package com.trianacodes.script.vapeapp.ui;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.trianacodes.script.vapeapp.R;
import com.trianacodes.script.vapeapp.clases.Aromas;
import com.trianacodes.script.vapeapp.sqlite.DbHelper;
import com.trianacodes.script.vapeapp.sqlite.OperacionesBasesDeDatos;

import static java.lang.Integer.parseInt;

// TODO: Cambiar apariencia a los SeekBar
// TODO: Hacer que al recibir el foco un EditText seleccione todo el texto
/* Todo: Anotar en los apuntes de Android que para hacer que un componente de la interfaz no obtenga
         nunca el foco, hay que hacerlo desde el XML de la interfaz, en la etiqueta del elemento,
         poniendo android:focusable = "false"*/
/* Todo: Anotar en los apuntes de Android que para controlar si un EditText está vacío o no, se usa
         el método isEmpty()*/
/*Todo: Anotar en los apuntes que para cambiar de color un hint hay que usar la propiedad
        android:textColorHint (android:textColorHint="@color/<nombre del color que he creado>"*/
public class AromasActivity extends AppCompatActivity {

    private Spinner desplegable;
    private SeekBar sbPorcentaje, sbMinMaceracion, sbMaxMaceracion;
    private TextView ePorcentaje, eMinMaceracion, eMaxMaceracion;
    private EditText eNombre, eMarca;
    private String controlVacio;
    private final DbHelper AyudaDb = new DbHelper(this);
    private Button Nuevo, Modificar, Eliminar;
    OperacionesBasesDeDatos operacionesDatos;
    private Aromas aroma = new Aromas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aromas);

        eNombre = findViewById(R.id.etNombre);
        eMarca = findViewById(R.id.etMarca);
        sbPorcentaje = findViewById(R.id.sbPorcentaje);
        ePorcentaje = findViewById(R.id.etPorcentaje);
        sbMinMaceracion = findViewById(R.id.sbMinMaceracion);
        eMinMaceracion = findViewById(R.id.etMinMaceracion);
        sbMaxMaceracion = findViewById(R.id.sbMaxMaceracion);
        eMaxMaceracion = findViewById(R.id.etMaxMaceracion);
        Nuevo = findViewById(R.id.btnAnadir);
        Modificar = findViewById(R.id.btnModificar);
        Eliminar = findViewById(R.id.btnEliminar);
        // Obtengo una instancia de la base de datos
        operacionesDatos = OperacionesBasesDeDatos.obtenerInstancia(getApplicationContext());
        /* Después del new llamo al constructor de la clase. Si este contructor tuviera que recibir
        *  algún parámetro, se tendría que especificar dentro de los paréntesis.*/
        Procesos();
        controlBotones();

    }

    public void Procesos(){

        try {

            //Llamo a la función que rellena de datos el desplegable
            rellenaDesplegable();
            controlDesplegable();
            /*Llamo a la función que va a controlar si se cambia el valor del SeekBar y si es así,
            modificar el contenido del EditText correspondiente*/
            controlaSbPorcetaje();
            controlaSbMinimo();
            controlaSbMaximo();
             /*Llamo a la función que va a controlar si el contenido del EditText ha cambiado y si es
            así, cambio el valor del SeekBar.*/
            /*controlaEdtPorcentaje();
            controlaEdtMinimo();
            controlaEdtMaximo();*/

        } catch (Exception e) {

            Toast.makeText(this, "Error " + e, Toast.LENGTH_SHORT);

        }

    }

    public void rellenaDesplegable(){

        /*He definido dentro de strings.xml un string-array llamado "tipos", con todos los tipos de
         * aromas. Ahora,, en esta línea creo un adaptador de tipo ArrayAdapter para luego rellenar
         * la lista desplegable (Spinner)*/
        ArrayAdapter tipos = ArrayAdapter.createFromResource(this, R.array.tipos,
                android.R.layout.simple_spinner_dropdown_item);
        // Asigno el desplegable de la interfaz al objeto de tipo Spinner que he creado (desplegable)
        desplegable = findViewById(R.id.spTipo);
        // Establezco el tipo de lista del adaptador
        tipos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Le asigno al objeto de tipo Spinner el adaptador que he construido
        desplegable.setAdapter(tipos);

    }

    public void controlDesplegable(){

        try {

            desplegable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    aroma.setTipo(adapterView.getItemAtPosition(i).toString());

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }

            });

        } catch (Exception e) {

            Toast.makeText(this,e.getMessage().toString(),Toast.LENGTH_LONG);

        }

    }

    public void controlaSbPorcetaje(){
        try {

                sbPorcentaje.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                @Override
                public void onProgressChanged(SeekBar porcentaje, int i, boolean b) {

                /* Uso String.ValueOf para que el número almacenado en porcentaje.getProgress()
                lo tome el EditText con formato texto, ya que los EditText sólo admiten contenido
                de tipo String.*/

                    ePorcentaje.setText(String.valueOf(porcentaje.getProgress()));

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

        } catch (Exception e) {

            Toast.makeText(this, "El error es: " + e.getMessage().toString(), Toast.LENGTH_SHORT);

        }

    }

    public void controlaSbMinimo(){

        try {

                sbMinMaceracion.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar minimo, int i, boolean b) {

                 /* Uso String.ValueOf para que el número almacenado en porcentaje.getProgress()
                lo tome el EditText con formato texto, ya que los EditText sólo admiten contenido
                de tipo String.*/

                    eMinMaceracion.setText(String.valueOf(minimo.getProgress()));

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }

            });


        } catch (Exception e) {

            Toast.makeText(this, "El error es: " + e.getMessage().toString(), Toast.LENGTH_SHORT);

        }

    }

    public void controlaSbMaximo(){

        sbMaxMaceracion.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar maximo, int i, boolean b) {

                 /* Uso String.ValueOf para que el número almacenado en porcentaje.getProgress()
                lo tome el EditText con formato texto, ya que los EditText sólo admiten contenido
                de tipo String.*/

                eMaxMaceracion.setText(String.valueOf(maximo.getProgress()));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

    }

    /*public void controlaEdtPorcentaje(){

        try {

            ePorcentaje.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    controlVacio = ePorcentaje.getText().toString();
                    if (controlVacio.isEmpty()){

                        controlVacio = "0";

                    }

                    sbPorcentaje.setProgress(parseInt(controlVacio));

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

        } catch (Exception e){

            Toast.makeText(this, "El error es: " + e, Toast.LENGTH_SHORT);

        }

    }

    public void controlaEdtMinimo(){

        try {

            eMinMaceracion.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                   controlVacio = eMinMaceracion.getText().toString();
                    if (controlVacio.isEmpty()){

                        controlVacio = "0";

                    }

                    sbMinMaceracion.setProgress(parseInt(controlVacio));

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }

            });


        } catch (Exception e) {

            Toast.makeText(this, "El error es: " + e, Toast.LENGTH_SHORT);

        }

    }

    public void controlaEdtMaximo(){

        try{

            eMaxMaceracion.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    controlVacio = eMaxMaceracion.getText().toString();
                    if (controlVacio.isEmpty()){


                        controlVacio = "0";

                    }

                    sbMaxMaceracion.setProgress(parseInt(controlVacio));

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }

            });

        } catch (Exception e){

            Toast.makeText(this, "El error es: " + e, Toast.LENGTH_SHORT);

        }

    }*/

    public void controlBotones(){

        Nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                estableceValores();
                // Ejecuto la tarea asíncrona de inserción de registro
                new insertaAromas().execute();


            }

        });

    }

    // Creo tarea asíncrona de inserción de registro
    public class insertaAromas extends AsyncTask<Void, Void, Void>{


        @Override
        protected Void doInBackground(Void... voids) {

            try {

                operacionesDatos.getDb().beginTransaction();
                operacionesDatos.insertarAroma(aroma);

            } catch (Exception e){



            }

            return null;

        }

    }

    public void estableceValores(){

        aroma.setNombre(eNombre.getText().toString());
        aroma.setMarca(eMarca.getText().toString());
        aroma.setPorcentajeRecomendado(sbPorcentaje.getProgress());
        aroma.setTiempoMinimoMaceracion(sbMinMaceracion.getProgress());
        aroma.setTiempoMaximoMaceracion(sbMaxMaceracion.getProgress());

    }

}
