package com.example.manish.ordermenu;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login2page extends AppCompatActivity {

    LoginDatabase loginDb ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2page);
        loginDb = new LoginDatabase(this);
    }

    private void checkID() {
        boolean flag = false;
        Intent intent = new Intent(this, MainActivity.class);

        Cursor res = loginDb.getData();
        if (res.getCount() == 0) {
            Toast.makeText(this, "No id Found", Toast.LENGTH_LONG);
            return;
        }

        while (res.moveToNext()) {

            if (res.getString(1).equals(getUsername())) {
                if (res.getString(2).equals(getPassword())) {
                    intent.putExtra("personName", res.getString(3));
                    startActivity(intent);
                    flag = true;
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Wrong ID or Password", Toast.LENGTH_SHORT).show();
                }
            }
        }


        if (!flag)
            Toast.makeText(this, "Create Login first", Toast.LENGTH_SHORT).show();
    }


    private String getUsername() {
        EditText personName = (EditText) findViewById(R.id.loginName);
        String finalName = personName.getText().toString();
        return finalName;
    }

    private String getPassword() {
        EditText password = (EditText) findViewById(R.id.password);
        String finalName = password.getText().toString();
        return finalName;
    }

    public void login(View view) {
        checkID();

    }

    public void create ( View view) {
        Intent intent = new Intent(this, CreateLogin.class);
        startActivity(intent);
    }


}
