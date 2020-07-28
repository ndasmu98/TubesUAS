package com.apps.newsapp.activities.Preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class Preference {
    private static String SESSION = "com.apps.newsapp";
    private static String LOGIN_STATUS = "LOGIN_STATUS";

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public static void setLoginStatus(boolean FirstLogin, Context context){
        sharedPreferences = context.getSharedPreferences(SESSION, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean(LOGIN_STATUS, FirstLogin);
        editor.apply();
    }

    public static boolean getLoginStatus(Context context){
        sharedPreferences = context.getSharedPreferences(SESSION, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(LOGIN_STATUS, false);
    }

    public static void setLogOut(Context context){
        sharedPreferences = context.getSharedPreferences(SESSION, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.remove(LOGIN_STATUS);
        editor.apply();
    }
}
