package th3g3ntl3m3n.storefiles.ImageData;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by th3g3ntl3m3n on 1/9/17.
 */

public class Constants {
    public static final String LOCK = "LOCK";
    public static final String LOCKFILE = "LOCKFILE";
    private static SharedPreferences lockPreferences;
    private static SharedPreferences.Editor lockEditor;
    private static final int PRIVATE = Context.MODE_PRIVATE;
    private static final String DEFAULT = "NULL";

    public static boolean isPasswordStored(Context context) {
        lockPreferences = context.getSharedPreferences(LOCKFILE, PRIVATE);
        return !lockPreferences.getString(LOCK, DEFAULT).equals(DEFAULT);
    }

    public static void storePassword(Context context, String password) {
        lockPreferences = context.getSharedPreferences(LOCKFILE, PRIVATE);
        lockEditor = lockPreferences.edit();
        lockEditor.putString(LOCK, password);
        lockEditor.apply();
    }

    public static String getPassword(Context context) {
        return context.getSharedPreferences(LOCKFILE, PRIVATE).getString(LOCK, DEFAULT);
    }

}
