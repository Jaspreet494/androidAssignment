package com.example.malert;

import android.app.Application;

import com.example.malert.helper.MyDatabaseAdapter;

/**
 * This class overrides the application class, which helps create a SQLite on start of application
 */
public class MyApplication extends Application {

    public static MyDatabaseAdapter myDatabaseAdapter;

    /**
     * Create a Database adapter on start of application
     */
    @Override
    public void onCreate() {
        super.onCreate();
        myDatabaseAdapter = new MyDatabaseAdapter(getApplicationContext());
    }
}
