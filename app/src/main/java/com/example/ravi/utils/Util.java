package com.example.ravi.utils;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

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

    public static String getPathFromCameraData(Intent data, Context context) {
        Uri selectedImage = data.getData();
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(selectedImage,
                filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        cursor.close();
        return picturePath;
    }
}
