package com.app.pareek.sandeep.officeexpensemanager.helper;

import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.app.pareek.sandeep.officeexpensemanager.Entity.Expense;

/**
 * Created by sandeep on 8/9/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = DatabaseHelper.class.getName();

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "OfficeExpenseManager";

    // Table Names
    private static final String TABLE_EXPENSE = "expense";

    private static final String KEY_PERSONNAME = "person_name";
    private static final String  KEY_PRODUCTNAME = "product_name";
    private static final String  KEY_DATEOFPURCHASE = "date_of_purchase";
    private static final String  KEY_QUANTITY = "product_quantity";
    private static final String  KEY_TRANSACTIONID = "transation_id";
    private static final String  KEY_EMPLOYEEID = "employee_id";
    private static final String KEY_EXPENSEAMOUNT = "expense_amount";

    // Table Create Statements
    private static final String CREATE_TABLE_EXPENSE = "CREATE TABLE "
            + TABLE_EXPENSE
            + "(" + KEY_TRANSACTIONID + " INTEGER PRIMARY KEY,"
            + KEY_EMPLOYEEID + " INTEGER" + ")";
            //+ KEY_STATUS + " INTEGER,"
            //+ KEY_CREATED_AT + " DATETIME" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_EXPENSE);
        Log.d("TABLE CREATED", "TABLE CREATED");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENSE);
        // create new tables
        onCreate(db);
    }


    /**
     * Saving a transaction of purchase.
     */
    public long saveTransaction(Expense expense) {
        SQLiteDatabase db = this.getWritableDatabase();
        long transactionId = -1;

        ContentValues values = new ContentValues();
        //values.put(KEY_PERSONNAME, expense.getPersonName());
        //values.put(KEY_PRODUCTNAME, expense.getProductName());
        //values.put(KEY_DATEOFPURCHASE, expense.getDateOfPurchase());
        //values.put(KEY_QUANTITY, expense.getQuantity());
        //values.put(KEY_TRANSACTIONID, expense.getTransactionId());
        values.put(KEY_TRANSACTIONID, expense.getTransactionId());
        values.put(KEY_EMPLOYEEID, expense.getEmployeeId());
        //values.put(KEY_EXPENSEAMOUNT, expense.getExpense());

        try {
            transactionId = db.insert(TABLE_EXPENSE, null, values);
        }catch(SQLiteException ex){
            ex.printStackTrace();
            Log.d("Data in database not inserted. Error code:4561","Error while inserting data");
        }
        db.close();
        Log.d("VALUES SAVED", "VALUES "+transactionId + "saved");
        return transactionId;
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    /**
     * gett datetime
     * */
    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}