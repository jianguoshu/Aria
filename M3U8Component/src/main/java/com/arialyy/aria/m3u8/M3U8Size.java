package com.arialyy.aria.m3u8;


import android.content.Context;

public class M3U8Size extends BasePreferences {
    public M3U8Size(Context context) {
        super(context);
    }


    @Override
    protected String getName() {
        return Name.M3U8_FILE_SIZE;
    }
}
