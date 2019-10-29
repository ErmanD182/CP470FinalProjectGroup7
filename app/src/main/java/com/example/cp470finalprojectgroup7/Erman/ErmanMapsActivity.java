package com.example.cp470finalprojectgroup7.Erman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.cp470finalprojectgroup7.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ErmanMapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int REQUEST_INT = 150;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erman_maps);
        Toolbar toolbar = findViewById(R.id.ErmantoolbarID);
        toolbar.setTitle("musicLocal");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public boolean onCreateOptionsMenu(Menu m){
        getMenuInflater().inflate(R.menu.erman_toolbar_menu, m );
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem mi){
        switch (mi.getItemId()){
            case R.id.Erman_action_one:
                Toast toast = Toast.makeText(getApplicationContext(), getResources().getString(R.string.ErmantempText), Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.Erman_settings:
                toast = Toast.makeText(getApplicationContext(), getResources().getString(R.string.ErmansettingsAboutText), Toast.LENGTH_LONG);
                toast.show();
                break;
        }
        return true;
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //Set current location:
        //Get permission to access device location
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&  ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_INT);
            }

        }
        //Permission Granted
        else{
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
        }

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(43.472357, -80.526327);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Wilfrid Laurier University"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
