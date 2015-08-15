package com.app.pareek.sandeep.officeexpensemanager;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.app.pareek.sandeep.officeexpensemanager.Entity.Expense;
import com.app.pareek.sandeep.officeexpensemanager.helper.DatabaseHelper;


public class AddExpense extends Activity implements View.OnClickListener{

    Button saveExpense,cancelExpense;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        saveExpense = (Button) findViewById(R.id.buttonSaveExp);
        cancelExpense = (Button) findViewById(R.id.buttonCanelExp);

        saveExpense.setOnClickListener(this);
        cancelExpense.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonSaveExp){
            //TODO: call database and save
            Toast.makeText(getApplicationContext(), "Saving Expn", Toast.LENGTH_SHORT).show();
            db= new DatabaseHelper(this);

            //just to test database connection
            Expense e = new Expense();
            e.setTransactionId(123456);
            e.setEmployeeId(19);

            long transactionId = db.saveTransaction(e);

            Toast.makeText(getApplicationContext(), "SAVED!!!! "+transactionId + "HH", Toast.LENGTH_SHORT).show();
            //
        }else if(v.getId()==R.id.buttonCanelExp){
            //TODO: cancel
            Toast.makeText(getApplicationContext(), "Cancel Exp", Toast.LENGTH_SHORT).show();
            finish();
        }

    }
}
