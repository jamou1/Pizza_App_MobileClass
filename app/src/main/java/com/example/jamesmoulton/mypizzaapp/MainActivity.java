package com.example.jamesmoulton.mypizzaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseIntArray;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.CheckedInputStream;

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
        RadioGroup radioHereOrThereGroup;
        RadioButton radioHereOrThereButton;
        CheckBox ONE, TWO, THREE;




        Intent intent = new Intent(this, DisplayOrderDetailsActivity.class);
        //Get selected radioButton from radioGroup
        radioSizeGroup = (RadioGroup) findViewById(R.id.radioSize);
        int selectedId = radioSizeGroup.getCheckedRadioButtonId();
        //find the radio button by returned id
        radioSizeButton = (RadioButton) findViewById(selectedId);
        //retrieve the value and pass it to the next activity
        CharSequence szSize = radioSizeButton.getText();
        intent.putExtra("pizzaSize", szSize);

        //Crust Spinner
        final Spinner spin = (Spinner) findViewById(R.id.CrustSpinner);
        TextView textSel = (TextView) spin.getSelectedView();
        String selectedText = textSel.getText().toString();
        CharSequence pzCrust = textSel.getText().toString();
        intent.putExtra("crustType", pzCrust);

        //Toppings Checkbox
        ONE = (CheckBox) findViewById(R.id.checkBoxPep);
        TWO = (CheckBox) findViewById(R.id.checkBoxOnion);
        THREE = (CheckBox) findViewById(R.id.checkBoxSausage);
        if(ONE.isChecked()) {
            CharSequence top = ONE.getText();
            intent.putExtra("toppingType", top);
        }
        if(TWO.isChecked()) {
            CharSequence top = TWO.getText();
            intent.putExtra("toppingType", top);
        }
        if(THREE.isChecked()) {
            CharSequence top = THREE.getText();
            intent.putExtra("toppingType", top);
        }
        if(ONE.isChecked() && TWO.isChecked()) {
            CharSequence top = ONE.getText() + " & " + TWO.getText();
            intent.putExtra("toppingType", top);
        }
        if (ONE.isChecked() && TWO.isChecked() && THREE.isChecked()) {
            CharSequence top = ONE.getText() + " & " + TWO.getText() + " & " + THREE.getText();
            intent.putExtra("toppingType", top);
        }
        if (TWO.isChecked() && THREE.isChecked()) {
            CharSequence top = TWO.getText() + " & " + THREE.getText();
            intent.putExtra("toppingType", top);
        }
        if (ONE.isChecked() && THREE.isChecked()) {
            CharSequence top = ONE.getText() + " & " + THREE.getText();
            intent.putExtra("toppingType", top);
        }


        //Pickup or Delivery
        radioHereOrThereGroup = (RadioGroup) findViewById(R.id.radioHereOrThere);
        int pickedId = radioHereOrThereGroup.getCheckedRadioButtonId();
        radioHereOrThereButton = (RadioButton) findViewById(pickedId);
        CharSequence pzOrder = radioHereOrThereButton.getText();
        intent.putExtra("pickOrDel", pzOrder);


        startActivity(intent);
    }
}
