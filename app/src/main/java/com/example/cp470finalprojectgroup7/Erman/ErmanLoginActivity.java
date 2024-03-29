package com.example.cp470finalprojectgroup7.Erman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cp470finalprojectgroup7.R;

public class ErmanLoginActivity extends AppCompatActivity {
    Button loginButton;
    EditText emailEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erman_login);
        emailEditText = (EditText)findViewById(R.id.ErmanloginEmailEditText);
        getSupportActionBar().hide();

        SharedPreferences getSP = getSharedPreferences("DefaultEmail", Context.MODE_PRIVATE);
        String defaultEmail = getResources().getString(R.string.DefaultEmailText);
        String emailText = getSP.getString(String.valueOf(R.string.SavedEmailText),defaultEmail);
        emailEditText.setText(emailText);

        loginButton = (Button)findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText = emailEditText.getText().toString();
                SharedPreferences setSP = getSharedPreferences("DefaultEmail",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = setSP.edit();
                editor.putString(String.valueOf(R.string.SavedEmailText),emailText);
                editor.commit();

                Intent intent = new Intent(ErmanLoginActivity.this,ErmanMapsActivity.class);
                startActivity(intent);
            }
        });
    }
}
