package com.example.manish.ordermenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateLogin extends AppCompatActivity {

    LoginDatabase loginDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_login);
        loginDb = new LoginDatabase(this);
    }

    public void createLogin (View view) {
        EditText eUsername = (EditText) findViewById(R.id.createUserET);
        EditText ePassword = (EditText) findViewById(R.id.createPassET);
        EditText eName = (EditText) findViewById(R.id.createNameET);

        String username = eUsername.getText().toString();
        String password = ePassword.getText().toString();
        String name = eName.getText().toString();

        boolean isCreated = loginDb.createID(username,password,name);

        if(isCreated)
            Toast.makeText(this, "Login ID successfully created", Toast.LENGTH_LONG);
        else
            Toast.makeText(this, "Login ID not created", Toast.LENGTH_LONG);

    }

    public void backToLogin (View view) {
        Intent intent = new Intent(this, Login2page.class);
        startActivity(intent);
    }
}
