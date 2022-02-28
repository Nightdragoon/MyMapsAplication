package com.joaquinemmanuel.mymapsaplication;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionRequester {
    public final static int REQUEST_ACCEPTED = 1;
    Context context;
    Activity activity;
    public PermissionRequester(Context context , Activity activity){
        this.activity = activity;
        this.context = context;
    }
    public boolean checkPermission(){
        boolean checkACL = ContextCompat.checkSelfPermission(context , Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        boolean checkI = ContextCompat.checkSelfPermission(context , Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED;
        boolean checkAFL = ContextCompat.checkSelfPermission(context , Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        boolean checkWES = ContextCompat.checkSelfPermission(context , Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        if (checkACL && checkI && checkAFL && checkWES){
            Toast.makeText(context, "Permiso dados", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            return false;
        }
    }
    public void requestPermission(){
        boolean requestACL = ActivityCompat.shouldShowRequestPermissionRationale(activity , Manifest.permission.ACCESS_COARSE_LOCATION);
        boolean requesti = ActivityCompat.shouldShowRequestPermissionRationale(activity , Manifest.permission.INTERNET);
        boolean requestAFL = ActivityCompat.shouldShowRequestPermissionRationale(activity , Manifest.permission.ACCESS_FINE_LOCATION);
        boolean requestWES = ActivityCompat.shouldShowRequestPermissionRationale(activity , Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (requestACL && requestAFL && requestWES && requesti){
            Toast.makeText(context, "Permiso dado", Toast.LENGTH_SHORT).show();
        }else{
            ActivityCompat.requestPermissions(activity , new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE , Manifest.permission.INTERNET , Manifest.permission.ACCESS_FINE_LOCATION , Manifest.permission.ACCESS_COARSE_LOCATION  , } , REQUEST_ACCEPTED );
        }
    }
}
