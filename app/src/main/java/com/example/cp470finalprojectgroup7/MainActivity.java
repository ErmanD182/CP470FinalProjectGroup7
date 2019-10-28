package com.example.cp470finalprojectgroup7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cp470finalprojectgroup7.Erman.ErmanLoginActivity;
import com.example.cp470finalprojectgroup7.Stuart.StuartLoginActivity;

public class MainActivity extends AppCompatActivity {
Button ermanButton;
Button stuartButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ermanButton = (Button)findViewById(R.id.Ermanbutton);
        ermanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ErmanLoginActivity.class);
                startActivity(intent);
            }
        });

        stuartButton = (Button)findViewById(R.id.Stuartbutton);
        stuartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StuartLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
