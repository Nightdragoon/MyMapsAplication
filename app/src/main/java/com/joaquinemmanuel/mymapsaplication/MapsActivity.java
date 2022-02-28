package com.joaquinemmanuel.mymapsaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import org.osmdroid.config.Configuration;
import org.osmdroid.views.MapView;

public class MapsActivity extends AppCompatActivity {
    MapView mapView;
    Double latitud;
    Double longitud;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PermissionRequester pm = new PermissionRequester(this , this);
        Context context = getApplicationContext();
        Configuration.getInstance().load(context , PreferenceManager.getDefaultSharedPreferences(context));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mapView = findViewById(R.id.mapView);

        extrasSended();
        if (pm.checkPermission()){
            Toast.makeText(this, "permiso dado", Toast.LENGTH_SHORT).show();
            mapStartUp();
        }else{
            pm.requestPermission();
        }


    }

    public void mapStartUp(){
        MapController mp = new MapController(latitud , longitud , this , mapView );
        mp.configurateMap(title);
    }

    public void extrasSended(){
        Bundle parametros = getIntent().getExtras();
        latitud = parametros.getDouble("latitud");
        longitud = parametros.getDouble("longitud");
        title = parametros.getString("monumentos");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}