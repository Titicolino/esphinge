package com.br.esphinge.motor;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Tiago on 20/04/2015.
 */
public class DimensoesTela {

    private DisplayMetrics metrics;

    public DimensoesTela(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        metrics = new DisplayMetrics();
        display.getMetrics(metrics);
    }

    public int getAltura() {
        return metrics.heightPixels;
    }

    public int getLargura() {
        return metrics.widthPixels;
    }
}