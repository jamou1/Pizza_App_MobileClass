package com.example.jamesmoulton.mypizzaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class DisplayOrderDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_order_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Pizza size
        Intent intent = getIntent();
        String message = intent.getStringExtra("pizzaSize");
        TextView t = (TextView)findViewById(R.id.tvPizzaSize);
        t.setText("Pizza size = " + message);


        //Crust Type
        String textSel = intent.getStringExtra("crustType");
        TextView c = (TextView)findViewById(R.id.tvCrustType);
        c.setText("You selected " + textSel + " crust");

        //Toppings choice
        String topChoice = intent.getStringExtra("toppingType");
        TextView tp = (TextView)findViewById(R.id.tvToppings);
        tp.setText("Topped with " + topChoice);

        //Pickup or Delivery
        String messageTwo = intent.getStringExtra("pickOrDel");
        TextView p = (TextView)findViewById(R.id.tvPickDeliv);
        p.setText("Order Type:  " + messageTwo);  //Why does this keep pulling the size?


    }

}
