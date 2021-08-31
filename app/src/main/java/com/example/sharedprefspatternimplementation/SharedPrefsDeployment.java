package com.example.sharedprefspatternimplementation;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Develop static methods here with specific models, context and prefs_names passes as parameters for shared preferences
 */

public class SharedPrefsDeployment {

    public static void saveUserAuth(User user, Context context, String PREFS_NAME) {

        SharedPreferences pref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt(SharedPrefrenceConstants.ID_KEY, user.getId());
        editor.putString(SharedPrefrenceConstants.EMAIL_KEY, user.getEmail());
        editor.putString(SharedPrefrenceConstants.NAME_KEY, user.getName());
        editor.putString(SharedPrefrenceConstants.TENANT_KEY, user.getTenant());
        editor.apply();
    }

    public static User getUserAuth(Context context) {

        SharedPreferences pref = context.getSharedPreferences(SharedPrefrenceConstants.ALL_PREFS, Context.MODE_PRIVATE);

        int id = pref.getInt(SharedPrefrenceConstants.ID_KEY, SharedPrefrenceConstants.DEFAULT_ID_VALUE);
        String email = pref.getString(SharedPrefrenceConstants.EMAIL_KEY, SharedPrefrenceConstants.DEFAULT_EMAIL_VALUE);
        String name = pref.getString(SharedPrefrenceConstants.NAME_KEY, SharedPrefrenceConstants.DEFAULT_NAME_VALUE);
        String tenant = pref.getString(SharedPrefrenceConstants.TENANT_KEY, SharedPrefrenceConstants.DEFAULT_TENANT_VALUE);

        User user = new User();
        user.setEmail(email);
        user.setId(id);
        user.setTenant(tenant);
        user.setName(name);

        return user;
    }

    public static void removeFile(Context context, String PREFS_NAME) {
        SharedPreferences pref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.clear();
        editor.apply();
    }
}
