package com.arialyy.aria.m3u8;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class BasePreferences implements IPreferences {

    private SharedPreferences mPreference;

    public BasePreferences( Context context) {
        mPreference = context.getSharedPreferences(getName(), Context.MODE_PRIVATE);
    }

    
    protected abstract @IPreferences.Name
    String getName();

    @Override
    public Map<String, ?> getAll() {
        return mPreference.getAll();
    }

    
    @Override
    public String getString(String key,  String defValue) {
        return mPreference.getString(key, defValue);
    }

    
    @Override
    public Set<String> getStringSet(String key) {
        return new HashSet<>(mPreference.getStringSet(key, new HashSet<String>()));
    }

    @Override
    public int getInt(String key, int defValue) {
        return mPreference.getInt(key, defValue);
    }

    @Override
    public long getLong(String key, long defValue) {
        return mPreference.getLong(key, defValue);
    }

    @Override
    public float getFloat(String key, float defValue) {
        return mPreference.getFloat(key, defValue);
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        return mPreference.getBoolean(key, defValue);
    }

    @Override
    public boolean contains(String key) {
        return mPreference.contains(key);
    }

    @Override
    public SharedPreferences.Editor edit() {
        return mPreference.edit();
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        mPreference.registerOnSharedPreferenceChangeListener(listener);
    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        mPreference.unregisterOnSharedPreferenceChangeListener(listener);
    }

    @Override
    public void commitBoolean(String key, boolean value) {
        mPreference.edit().putBoolean(key, value).commit();
    }

    @Override
    public void commitInt(String key, int defValue) {
        mPreference.edit().putInt(key, defValue).commit();
    }

    @Override
    public void commitLong(String key, long defValue) {
        mPreference.edit().putLong(key, defValue).commit();
    }

    @Override
    public void commitFloat(String key, float defValue) {
        mPreference.edit().putFloat(key, defValue).commit();
    }

    @Override
    public void commitString(String key, String value) {
        mPreference.edit().putString(key, value).commit();
    }

    @Override
    public void commitStringSet(String key,  Set<String> values) {
        mPreference.edit().putStringSet(key, values).commit();
    }

    @Override
    public void applyBoolean(String key, boolean value) {
        mPreference.edit().putBoolean(key, value).apply();
    }

    @Override
    public void applyInt(String key, int defValue) {
        mPreference.edit().putInt(key, defValue).apply();
    }

    @Override
    public void applyLong(String key, long defValue) {
        mPreference.edit().putLong(key, defValue).apply();
    }

    @Override
    public void applyFloat(String key, float defValue) {
        mPreference.edit().putFloat(key, defValue).apply();
    }

    @Override
    public void applyString(String key, String value) {
        mPreference.edit().putString(key, value).apply();
    }

    @Override
    public void applyStringSet(String key,  Set<String> values) {
        mPreference.edit().putStringSet(key, values).apply();
    }

    @Override
    public void removeApply(String key) {
        mPreference.edit().remove(key).apply();
    }

    @Override
    public void removeCommit(String key) {
        mPreference.edit().remove(key).commit();
    }   
    
    @Override
    public void clearApply() {
        mPreference.edit().clear().apply();
    }

    @Override
    public void clearCommit() {
        mPreference.edit().clear().commit();
    }
}
