package io.github.ziginsider.epam_laba_7;

import android.graphics.Color;

import java.util.Random;

public class RandomColor {
    private static Random rnd;

    public static int generateNewColor() {
        rnd = new Random();
        return Color.argb(255,
                rnd.nextInt(256),
                rnd.nextInt(256),
                rnd.nextInt(256));
    }
}
