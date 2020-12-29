package com.arialyy.aria.m3u8;

import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

public interface IPreferences {
    Map<String, ?> getAll();

    String getString(String key, String defValue);

    Set<String> getStringSet(String key);

    int getInt(String key, int defValue);

    long getLong(String key, long defValue);

    float getFloat(String key, float defValue);

    boolean getBoolean(String key, boolean defValue);

    boolean contains(String key);

    SharedPreferences.Editor edit();

    void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener);

    void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener);

    void commitBoolean(String key, boolean value);

    void commitInt(String key, int defValue);

    void commitLong(String key, long defValue);

    void commitFloat(String key, float defValue);

    void commitString(String key, String value);

    void commitStringSet(String key,  Set<String> values);

    void applyBoolean(String key, boolean value);

    void applyInt(String key, int defValue);

    void applyLong(String key, long defValue);

    void applyFloat(String key, float defValue);

    void applyString(String key, String value);

    void applyStringSet(String key,  Set<String> values);

    void removeApply(String key);

    void removeCommit(String key);

    void clearApply();

    void clearCommit();

    @interface Name {
        String M3U8_FILE_SIZE = "m3u8_file_size";
    }
}
