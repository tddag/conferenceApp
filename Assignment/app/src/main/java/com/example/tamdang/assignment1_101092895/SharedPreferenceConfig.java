package com.example.tamdang.assignment1_101092895;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceConfig {

    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPreferenceConfig(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_preference), Context.MODE_PRIVATE);
    }

    public void writeLoginStatus (boolean status) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login_status_preference), status);
        editor.commit();
    }

    public void writeLoginUser(String username) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.commit();
    }

    public String readLoginUser(){
        return sharedPreferences.getString("username", "nothing");

    }

    public boolean readLoginStatus() {
        boolean status = false;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_preference), false);
        return status;
    }


}
