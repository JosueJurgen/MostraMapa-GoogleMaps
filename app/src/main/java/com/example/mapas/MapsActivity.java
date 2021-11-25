package com.example.mapas;

import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapas.databinding.ActivityMaps2Binding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMaps2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if (status == ConnectionResult.SUCCESS){
            SupportMapFragment mapFragment = (SupportMapFragment)
                    getSupportFragmentManager()
                            .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }else{

            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status,(Activity)getApplicationContext(),10
                    );
            dialog.show();
        }
    }

        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;
            // para seleccionar el tipo de mapa que queremos
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            // habilitar mapas ya que estan desabilitadas
            UiSettings uiSettings = mMap.getUiSettings();
            uiSettings.setZoomControlsEnabled(true);

            // marcador o posicion
            LatLng sydney = new LatLng(-13.52264, -71.96734);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Bienvenido a Cusco"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            // colocar zoom
            float zoolevel = 16;
        }
    }
