package top.aenlly.ftp_server.cache;

import android.content.Context;
import android.content.SharedPreferences;
import top.aenlly.ftp_server.constant.FtpConstant;

public class SharedPreferencesUtils {

    private static final String PREF_NAME = "ftp";

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private SharedPreferencesUtils() {
    }

    public static void init(Context context) {

        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        SharedPreferencesUtils.putString(FtpConstant.ENCODING, "UTF-8");
        SharedPreferencesUtils.putString(FtpConstant.PORT, "2121");
    }

    public static void putString(String key,String value) {
        editor.putString(key, value);
        editor.apply(); // 保存数据
    }

    public static void putInt(String key,int value) {
        editor.putInt(key, value);
        editor.apply(); // 保存数据
    }

    public static String getString(String key){
        return sharedPreferences.getString(key,"");
    }

    public static int getInt(String key){
        return sharedPreferences.getInt(key,0);
    }

    public static void clearData() {
        editor.clear(); // 清空所有数据
        editor.apply();
    }
}