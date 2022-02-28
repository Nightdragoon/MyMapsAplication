package com.joaquinemmanuel.mymapsaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btnAngelDeLaIndependecia;
    ImageButton btnMonumentoALaRevolucion;
    ImageButton btnTorreLatinoAmericana;
    ImageButton btnZocalo;
    Context context;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        activity = this;
        btnAngelDeLaIndependecia = findViewById(R.id.btnAngelDeLaIndependecia);
        btnMonumentoALaRevolucion = findViewById(R.id.btnMomumentoRevolucion);
        btnZocalo = findViewById(R.id.btnZocalo);
        btnTorreLatinoAmericana = findViewById(R.id.btnTorreLatinoAmericana);
        btnAngelDeLaIndependecia.setImageResource(R.drawable.angel_de_la_independencia);
        btnMonumentoALaRevolucion.setImageResource(R.drawable.monumento_a_la_revolcion);
        btnZocalo.setImageResource(R.drawable.banderademexico);
        btnTorreLatinoAmericana.setImageResource(R.drawable.torrelatino);
        btnTorreLatinoAmericana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMaps("Torre latino" , -99.14056 , 19.43393 );
            }
        });
        btnZocalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMaps("Zocalo" , -99.1332049 , 19.4326018);
            }
        });
        btnMonumentoALaRevolucion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMaps("Monumento a la revolucion" , -99.1542288	 ,  19.436365);
            }
        });
        btnAngelDeLaIndependecia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMaps("Angel de la inpendencia" ,  -99.1676463 , 19.4269903);
            }
        });
    }

    public void goToMaps(String tittle , Double longitud , Double latitud){
        PermissionRequester pm = new PermissionRequester(context , activity);
        if (pm.checkPermission()){
            Intent intent = new Intent(MainActivity.this , MapsActivity.class);
            intent.putExtra("monumentos", tittle);
            intent.putExtra("longitud" , longitud);
            intent.putExtra("latitud" , latitud);
            startActivity(intent);
        }else{
            pm.requestPermission();
        }
    }



}