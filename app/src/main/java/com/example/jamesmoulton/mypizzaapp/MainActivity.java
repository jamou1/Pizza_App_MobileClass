package com.example.jamesmoulton.mypizzaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onRadioButtonClicked(View view) {
        //Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        //Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rbSmall:
                if (checked)
                    //SMall
                    Toast.makeText(getApplicationContext(),
                            "Small", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbMedium:
                if (checked)
                    //Medium
                    Toast.makeText(getApplicationContext(),
                            "Medium", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rbLarge:
                if (checked)
                    //Large
                    Toast.makeText(getApplicationContext(),
                            "Large", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void sendOrder(View view) {
        //Do something in response to button
        RadioGroup radioSizeGroup;
        RadioButton radioSizeButton;
        Intent intent = new Intent(this, DisplayOrderDetailsActivity.class);
        //Get selected radioButton from radioGroup
        radioSizeGroup = (RadioGroup) findViewById(R.id.radioSize);
        int selectedId = radioSizeGroup.getCheckedRadioButtonId();
        //find the radio button by returned id
        radioSizeButton = (RadioButton) findViewById(selectedId);
        //retrieve the value and pass it to the next activity
        CharSequence szSize = radioSizeButton.getText();
        intent.putExtra("pizzaSize", szSize);
        startActivity(intent);
    }
}
