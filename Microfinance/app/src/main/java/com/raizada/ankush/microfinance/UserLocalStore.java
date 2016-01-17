package com.raizada.ankush.microfinance;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by yogeshdarji on 1/16/16.
 */
public class UserLocalStore {


    public static final String SP_NAME = "userDetails";

    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context) {
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user) {
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.putString("name", user.name);
        userLocalDatabaseEditor.putString("username", user.username);
        userLocalDatabaseEditor.putString("password", user.password);
        userLocalDatabaseEditor.putInt("age", user.age);
        userLocalDatabaseEditor.putString("ssn", user.ssn);
        userLocalDatabaseEditor.putString("email",user.email);
        userLocalDatabaseEditor.commit();
    }

    public void setUserLoggedIn(boolean loggedIn) {
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.putBoolean("loggedIn", loggedIn);
        userLocalDatabaseEditor.commit();
    }

    public void clearUserData() {
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.clear();
        userLocalDatabaseEditor.commit();
    }


    public boolean getUserLoggedIn()
    {
        if(userLocalDatabase.getBoolean("loggedIn",false)==true){
            return true;

        }

        else
            return false;
    }

    public User getLoggedInUser() {
        if (userLocalDatabase.getBoolean("loggedIn", false) == false) {
            return null;
        }

        String name = userLocalDatabase.getString("name", "");
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");
        int age = userLocalDatabase.getInt("age", -1);
        String ssn = userLocalDatabase.getString("ssn", "");
        String email = userLocalDatabase.getString("email", "");

        User user = new User(name, age,ssn,email, username, password);
        return user;
    }
}
