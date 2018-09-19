package com.example.manish.ordermenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Order_Receipt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__receipt);

        Bundle userData = getIntent().getExtras();
        if(userData == null) {
            return;
        }

        TextView orderReceiptDisplay = (TextView) findViewById(R.id.orderReceiptDisplay);
        String userName = userData.getString("Name of User");
        boolean isTomatoSauce = userData.getBoolean("Is tomato Sauce checked?");
        boolean isWhiteSauce = userData.getBoolean("Is White Sauce checked?");
        int quantity = userData.getInt("No. of plates");

        String ts = "Tomato Sauce Included\n";
        String ws = "White Sauce Included\n";
        String receiptText;

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

    public void backToMain (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

