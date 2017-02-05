package com.example.davetolentin.mathgame;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Dave Tolentin on 2/5/2017.
 */

public class SessionManager {

    private static String TAG = SessionManager.class.getSimpleName();
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;
    private static final String PREF_NAME = "Math";
    private int PRIVATE_MODE = 0;

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }
}
