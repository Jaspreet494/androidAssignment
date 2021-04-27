package com.example.malert.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.malert.data.MedicinePOJO;

import java.util.ArrayList;
import java.util.List;

/**
 * MyDatabaseAdapter is a adapter class which provides function to ADD/Insert/Delete/Find the Reminders from the SQLite DB
 */
public class MyDatabaseAdapter {

    MyDatabaseHelper myDatabaseHelper;

    public MyDatabaseAdapter(Context context)
    {
        myDatabaseHelper = new MyDatabaseHelper(context);
    }

    //insert data to the db
    public long insertData(String name, String description, String dateAndTime)
    {
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDatabaseHelper.NAME, name);
        contentValues.put(MyDatabaseHelper.DESCRIPTION, description);
        contentValues.put(MyDatabaseHelper.DATE_AND_TIME, dateAndTime);
        long id = sqLiteDatabase.insert(MyDatabaseHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    //get data from the db
    public List<MedicinePOJO> getData()
    {
        SQLiteDatabase db = myDatabaseHelper.getReadableDatabase();
        String[] columns = {
                MyDatabaseHelper.UID,
                MyDatabaseHelper.NAME,
                MyDatabaseHelper.DESCRIPTION,
                MyDatabaseHelper.DATE_AND_TIME
        };
        Cursor cursor =db.query(
                MyDatabaseHelper.TABLE_NAME,
                columns,null,null,null,null,null
        );
        List<MedicinePOJO> listOfMedicine = new ArrayList<>();
        while (cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex(MyDatabaseHelper.UID));
            String name =cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.NAME));
            String description =cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.DESCRIPTION));
            String dateAndTime =cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.DATE_AND_TIME));
            MedicinePOJO medicinePOJO = new MedicinePOJO(id, name, dateAndTime, description);
            listOfMedicine.add(medicinePOJO);
        }
        return listOfMedicine;
    }

    //delete data in the db
    public  int delete(int id)
    {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        String[] whereArgs = {String.valueOf(id)};

        int count = db.delete(MyDatabaseHelper.TABLE_NAME ,MyDatabaseHelper.UID + " = ?", whereArgs);
        return count;
    }

    //update data in the db
    public int updateDataByID(MedicinePOJO medicinePOJO)
    {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDatabaseHelper.NAME, medicinePOJO.getName());
        contentValues.put(MyDatabaseHelper.DESCRIPTION, medicinePOJO.getDescription());
        contentValues.put(MyDatabaseHelper.DATE_AND_TIME, medicinePOJO.getDateAndTime());
        String[] whereArgs= {String.valueOf(medicinePOJO.getId())};
        int count = db.update(MyDatabaseHelper.TABLE_NAME, contentValues, MyDatabaseHelper.UID+" = ?", whereArgs );
        return count;
    }

}
