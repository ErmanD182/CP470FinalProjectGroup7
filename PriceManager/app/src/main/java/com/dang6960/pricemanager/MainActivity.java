package com.dang6960.pricemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    protected EditText searchBar;
    protected Button searchButton;
    protected Toolbar mainToolbar;
    protected static int SEARCH_RESULT_CODE = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBar = findViewById(R.id.linkSearchBar);
        searchButton = findViewById(R.id.linkSearchButton);
        mainToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mainToolbar);

        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent changeActivityIntent = new Intent(MainActivity.this, ResultsActivity.class);
                startActivityForResult(changeActivityIntent, SEARCH_RESULT_CODE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu m){
        getMenuInflater().inflate(R.menu.main_toolbar_menu, m );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi){
        int selected_id = mi.getItemId();

        switch(selected_id){
            case R.id.aboutButton:
                Log.d("Toolbar", "About selected");
                Snackbar.make(findViewById(android.R.id.content), "CP470 Project Section by Mackenzie Dang", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
        }
        return true;
    }

}
