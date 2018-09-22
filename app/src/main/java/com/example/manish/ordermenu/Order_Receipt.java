package com.example.manish.ordermenu;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Order_Receipt extends AppCompatActivity {

    Bundle userData;
    String receiptText;
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__receipt);

        userData = getIntent().getExtras();
        if(userData == null) {
            return;
        }

        TextView orderReceiptDisplay = (TextView) findViewById(R.id.orderReceiptDisplay);
        String userName = userData.getString("Name of User");
        boolean isTomatoSauce = userData.getBoolean("Is tomato Sauce checked?");
        boolean isWhiteSauce = userData.getBoolean("Is White Sauce checked?");
        quantity = userData.getInt("No. of plates");

        String ts = "Tomato Sauce Included\n";
        String ws = "White Sauce Included\n";

        if(isTomatoSauce && isWhiteSauce)
            receiptText = userName + "\nNumber of plates ordered = " + quantity + "\n" +
                ts + ws + "Final Price = Rs." + 40*quantity;
        else if (isTomatoSauce)
            receiptText = userName + "\nNumber of plates ordered = " + quantity + "\n" +
                    ts + "Final Price = Rs." + 40*quantity;
        else if (isWhiteSauce)
            receiptText = userName + "\nNumber of plates ordered = " + quantity + "\n" +
                    ws + "Final Price = Rs." + 40*quantity;
        else
            receiptText = userName + "\nNumber of plates ordered = " + quantity + "\n" +
                    "Final Price = Rs." + 40*quantity;

        orderReceiptDisplay.setText(receiptText);
    }

    public void sendEmail (View view) {
        final String[] TO = {"bmanish20@gmail.com"};
        final String SUB = "Bazz Fries Receipt";
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, SUB);
        emailIntent.putExtra(Intent.EXTRA_TEXT, receiptText);
        try {
            startActivity(emailIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No email app", Toast.LENGTH_LONG);
        }

    }

    public void backToMain (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

