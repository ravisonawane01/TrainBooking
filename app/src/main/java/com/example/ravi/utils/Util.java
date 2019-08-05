package com.example.ravi.utils;

import android.content.Context;

import com.example.ravi.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    /**
     * applies regex on given string and returns true if string is valid else false
     *
     * @param regexPattern
     * @param data
     * @return
     */
    public static boolean applyRegex(String regexPattern, String data) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    public static void displayAlertDialog(final Context context, final String title, String msg) {
        new MaterialAlertDialogBuilder(context, R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog_Centered)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton("Ok", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
