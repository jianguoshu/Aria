package com.arialyy.aria.m3u8;

import android.content.Context;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class M3U8SizeHelper {
    private static M3U8Size m3U8Size;
    private static M3U8SizeHelper instance = new M3U8SizeHelper();

    public static synchronized M3U8SizeHelper getInstance(Context context) {
        if (m3U8Size == null) {
            m3U8Size = new M3U8Size(context);
        }
        return instance;
    }

    public void appendTs(String key, String ts, int index) {
        Pattern p = Pattern.compile(".*EXTINF:(.*),");
        Matcher matcher = p.matcher(ts);
        if (matcher.find() && matcher.groupCount() > 0) {
            long duration = (long) (Float.valueOf(matcher.group(1)) * 1000);
            if (index == 0) {
                m3U8Size.applyLong(key + "tsFirst", duration);
            }
            m3U8Size.applyLong(key, duration + m3U8Size.getLong(key, 0));
        }
    }

    public long calculateSize(String key, long tsSizeIndex0) {
        long durationTotal = m3U8Size.getLong(key, 0);
        long durationTsFirst = m3U8Size.getLong(key + "tsFirst", 0);
        if (durationTotal == 0 || durationTsFirst == 0 || tsSizeIndex0 == 0) {
            return 0;
        }
        return durationTotal / durationTsFirst * tsSizeIndex0;
    }
}
