package com.example.manish.ordermenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login2page extends AppCompatActivity {

    String names[] = new String[50];

    String password[] = new String[50];
    int last = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2page);

        String name  = "manish";
        names[0] = name;

        password[0] = "12345";
    }

    private void nameInput() {
        boolean flag = false;
        EditText personName = (EditText) findViewById(R.id.loginName);
        String finalName = personName.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);

        for(int i=0;i<=last;i++) {

            if(names[i].equals(finalName)){
                if(getPassword().equals(password[i]))
                {
                    intent.putExtra("personName",finalName);
                    startActivity(intent);
                    flag =true;
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(this, "Wrong ID or Password", Toast.LENGTH_SHORT).show();
                }
            }
        }

        if(!flag)
            Toast.makeText(this, "Create Login first", Toast.LENGTH_SHORT).show();

    }

    private String getPassword() {
        EditText password = (EditText) findViewById(R.id.password);
        String finalName = password.getText().toString();
        return finalName;
    }

    public void login(View view) {
        nameInput();

    }

    public void create ( View view) {
        EditText personName = (EditText) findViewById(R.id.loginName);
        String finalName = personName.getText().toString();
        names[++last] = finalName;

        EditText passwordG = (EditText) findViewById(R.id.password);
        String passwordX = passwordG.getText().toString();
        password[last] = passwordX;

        Toast.makeText(this, "Login created", Toast.LENGTH_SHORT).show();
    }


}
