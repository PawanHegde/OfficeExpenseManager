package com.app.pareek.sandeep.officeexpensemanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivityHome extends Activity implements View.OnClickListener{

    Button addExpenseButton, generateBillButton, exitAppButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addExpenseButton    =    (Button) findViewById(R.id.buttonAddExp);
        generateBillButton  =    (Button) findViewById(R.id.buttonGenerateBill);
        exitAppButton       =    (Button) findViewById(R.id.buttonExit);

        addExpenseButton.setOnClickListener(this);
        generateBillButton.setOnClickListener(this);
        exitAppButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonAddExp){
            Toast.makeText(getApplicationContext(), "Add Expense", Toast.LENGTH_SHORT).show();
            Intent intentAddExpense = new Intent(this, AddExpense.class);
            startActivity(intentAddExpense);
        }else if(v.getId()==R.id.buttonGenerateBill){
            Toast.makeText(getApplicationContext(), "Generate bill", Toast.LENGTH_SHORT).show();
        }else if(v.getId()==R.id.buttonExit){
            Toast.makeText(getApplicationContext(), "Bye Bye", Toast.LENGTH_SHORT).show();

            //Toast.makeText(getApplicationContext(), "Exiting the Game", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityHome.this);
            builder.setMessage("Are you Sure, You Wanna Exit?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    finish();

                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    arg0.cancel();

                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_home, menu);
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

}
