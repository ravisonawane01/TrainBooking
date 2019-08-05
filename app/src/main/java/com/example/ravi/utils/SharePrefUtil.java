package com.example.ravi.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePrefUtil {

    public static String getUserId(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("TrainApp",
                Context.MODE_PRIVATE);
        return prefs.getString("userId", "");
    }

    public static void setUserId(Context context, String userId) {
        SharedPreferences preferences = context.getSharedPreferences("TrainApp",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("userId", userId);
        editor.commit();
    }

    public static void clearUsernamePreference(Context context) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences("userId",
                Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.clear();
        editor.commit();
    }

    public static String getUId(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("TrainApp",
                Context.MODE_PRIVATE);
        return prefs.getString("uId", "");
    }

    public static void setUId(Context context, String uId) {
        SharedPreferences preferences = context.getSharedPreferences("TrainApp",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("uId", uId);
        editor.commit();
    }

    public static void clearuIdPreference(Context context) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences("uId",
                Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.clear();
        editor.commit();
    }
}
