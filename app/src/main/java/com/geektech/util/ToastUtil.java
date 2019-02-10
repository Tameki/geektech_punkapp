package com.geektech.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by askar on 2/10/19
 * with Android Studio
 */
public class ToastUtil {
    public static void showShortToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
