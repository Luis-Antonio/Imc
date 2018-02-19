package com.luisrodriguez.android.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//Se importa el widget Button
import android.widget.Button;
//Se importa el widget EditText
import android.widget.EditText;
//Se importa el widget TextView
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Se agregan las variables de instancia
    private EditText campo_peso;
    private EditText campo_estatura;
    private Button boton_calcular;
    private Button boton_limpiar;
    private TextView etiqueta_imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se enlazan las id de los atributos
        final EditText mCampoPeso = (EditText) findViewById(R.id.campo_peso);
        final EditText mCampoEstatura = (EditText) findViewById(R.id.campo_estatura);
        Button mBotonCalcular = (Button) findViewById(R.id.boton_calcular);
        Button mBotonLimpiar = (Button) findViewById(R.id.boton_limpiar);
        final  TextView mEtiquetaImc = (TextView) findViewById(R.id.etiqueta_imc);
        //Se programa el boton Calcular
        mBotonCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String s = mCampoPeso.getText().toString();
                double peso = Double.parseDouble(s);
                s = mCampoEstatura.getText().toString();
                double estatura = Double.parseDouble(s);
                double imc = peso / (estatura * estatura);
                s = String.format("%2.2f", imc);
                mEtiquetaImc.setText(s);
            }
        });
        //Se programa el boton Limpiar
        mBotonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCampoPeso.setText("");
                mCampoEstatura.setText("");
                mEtiquetaImc.setText("0.0");
            }
        });
    }
}
