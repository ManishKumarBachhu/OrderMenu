package com.example.manish.ordermenu;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;
    final int cost = 40;

    public void increment(View view)
    {
        quantity++;
        displayinq(quantity);
    }

    public void decrement(View view)
    {
        quantity--;
        displayinq(quantity);
    }

    private void displayinq (int quantity)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantityTextView);
        TextView priceDisplayTextView = (TextView) findViewById(R.id.priceDisplayTextView);
        quantityTextView.setText("" + quantity);
        priceDisplayTextView.setText("Total Price = Rs." + cost*quantity);
    }

    /*
    private void displayfinq (int number)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantityFinalTextView);
        quantityTextView.setText("Number of plates ordered:  " + number);
    }
    */

    private boolean tomatoSauce ()
    {
        CheckBox tomSauceCheckBox = (CheckBox) findViewById(R.id.tomatoSauceCheckBox);
        boolean hasTomatoSauce = tomSauceCheckBox.isChecked();
        return  hasTomatoSauce;

    }

    private boolean whiteSauce ()
    {
        CheckBox whiteSauceCheckBox = (CheckBox) findViewById(R.id.whiteSauceCheckBox);
        boolean hasWhiteSauce = whiteSauceCheckBox.isChecked();
        return hasWhiteSauce;
    }

    private String nameInput()
    {
        EditText personName = (EditText) findViewById(R.id.enterName);
        String finalName = personName.getText().toString();
        return finalName;
    }

    /*
    private void nameOutput(String finalName) {
        TextView finalNameTextView = (TextView) findViewById(R.id.receiptNameTextView);
        finalNameTextView.setText(finalName);
    } */

    public void submitOrder (View view)
    {
       // displayfinq(quantity);

        //String finalName = nameInput();
        //nameOutput(finalName);

       Intent intent = new Intent(this, Order_Receipt.class);

       intent.putExtra("Name of User",nameInput());
       intent.putExtra("No. of plates",quantity);
       intent.putExtra("Is tomato Sauce checked?",tomatoSauce());
       intent.putExtra("Is White Sauce checked",whiteSauce());

        startActivity(intent);
        //tomatoSauce();
        //whiteSauce();


    }

}
