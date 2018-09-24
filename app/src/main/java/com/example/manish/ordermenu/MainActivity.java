package com.example.manish.ordermenu;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Bundle userData;
    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userData = getIntent().getExtras();
        if(userData == null) {
            return;
        }

        TextView personName = (TextView) findViewById(R.id.nameTextView);
        userName = userData.getString("personName");
        personName.setText(userName);

    }

    int quantity = 0;
    final int cost = 40;

    public void increment(View view)
    {
        if(quantity<10)
            quantity++;
        else {
           Toast.makeText(this, "Maximum Number of plates per order is 10", Toast.LENGTH_SHORT).show();
        }
        displayinq(quantity);
    }

    public void decrement(View view)
    {
        if(quantity>0)
            quantity--;
        else {
            Toast.makeText(this, "Cannot order less than zero", Toast.LENGTH_SHORT).show();
        }

        displayinq(quantity);
    }

    private void displayinq (int quantity)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantityTextView);
        TextView priceDisplayTextView = (TextView) findViewById(R.id.priceDisplayTextView);
        quantityTextView.setText("" + quantity);
        priceDisplayTextView.setText("Total Price = Rs." + cost*quantity);
    }

    private boolean tomatoSauce () {
        CheckBox tomSauceCheckBox = (CheckBox) findViewById(R.id.tomatoSauceCheckBox);
        boolean hasTomatoSauce = tomSauceCheckBox.isChecked();
        return  hasTomatoSauce;

    }

    private boolean whiteSauce () {
        CheckBox whiteSauceCheckBox = (CheckBox) findViewById(R.id.whiteSauceCheckBox);
        boolean hasWhiteSauce = whiteSauceCheckBox.isChecked();
        return hasWhiteSauce;
    }

    /*private String nameInput()
    {
        EditText personName = (EditText) findViewById(R.id.enterName);
        String finalName = personName.getText().toString();
        return finalName;
    }*/

    /*private void notificationCaller () {
     NotificationCompat.Builder notification = new NotificationCompat.Builder(this)
             .setSmallIcon(R.mipmap.ic_launcher_round)
             .setContentTitle("Fries Order Submitted")
             .setContentText("Youv have submitted your order");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, notification.build());
     }*/

    public void submitOrder (View view)
    {

       // notificationCaller();

       Intent intent = new Intent(this, Order_Receipt.class);

       intent.putExtra("Name of User",userName);
       intent.putExtra("No. of plates",quantity);
       intent.putExtra("Is tomato Sauce checked?", tomatoSauce());
       intent.putExtra("Is White Sauce checked?", whiteSauce());

        startActivity(intent);
    }

    public void logout (View view) {
        Intent intent = new Intent(this, Login2page.class);
        startActivity(intent);
        Toast.makeText(this, "Logout successful", Toast.LENGTH_SHORT).show();
    }

}
