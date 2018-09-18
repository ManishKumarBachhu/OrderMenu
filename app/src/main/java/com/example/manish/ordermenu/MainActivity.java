package com.example.manish.ordermenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    private void displayinq (int number)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantityTextView);
        quantityTextView.setText("" + number);
    }

    private void displayfinq (int number)
    {
        TextView quantityTextView = (TextView) findViewById(R.id.quantityFinalTextView);
        quantityTextView.setText("Number of plates ordered:  " + number);
    }

    private void tomatoSauce ()
    {
        CheckBox tomSauceCheckBox = (CheckBox) findViewById(R.id.tomatoSauceCheckBox);
        boolean hasTomatoSauce = tomSauceCheckBox.isChecked();

        if(hasTomatoSauce)
        {
            TextView tomatoSauceTextView = (TextView) findViewById(R.id.tomatoSRTextView);
            tomatoSauceTextView.setText("Tomato Sauce is included.");
        }

        else
        {
            TextView tomatoSauceTextView = (TextView) findViewById(R.id.tomatoSRTextView);
            tomatoSauceTextView.setText("");
        }
    }

    private void whiteSauce ()
    {
        CheckBox whiteSauceCheckBox = (CheckBox) findViewById(R.id.whiteSauceCheckBox);
        boolean hasWhiteSauce = whiteSauceCheckBox.isChecked();

        if(hasWhiteSauce)
        {
            TextView tomatoSauceTextView = (TextView) findViewById(R.id.whiteSRTextView);
            tomatoSauceTextView.setText(com.example.manish.ordermenu.R.string.white_sauce_included);
        }

        else
        {
            TextView tomatoSauceTextView = (TextView) findViewById(R.id.whiteSRTextView);
            tomatoSauceTextView.setText("");
        }
    }

    private String nameInput()
    {
        EditText personName = (EditText) findViewById(R.id.enterName);
        String finalName = personName.getText().toString();
        return finalName;
    }

    private void nameOutput(String finalName)
    {
        TextView finalNameTextView = (TextView) findViewById(R.id.receiptNameTextView);
        finalNameTextView.setText(finalName);
    }

    public void submitOrder (View view)
    {
        displayfinq(quantity);

        String finalName = nameInput();
        nameOutput(finalName);

        tomatoSauce();

        whiteSauce();
    }

}
