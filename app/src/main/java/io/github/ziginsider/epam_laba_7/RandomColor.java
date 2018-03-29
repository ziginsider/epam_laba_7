package io.github.ziginsider.epam_laba_7;

import android.graphics.Color;

import java.util.Random;

/**
 * Implements static method {@link RandomColor#generateNewColor()} that returns random
 * color-int from red, green, blue components
 *
 * @author Alex Kisel
 * @since 2018-03-29
 */
public class RandomColor {
    /**
     * Returns random color-int from red, green, blue components
     *
     * @return random color-int
     */
    public static int generateNewColor() {
        Random rnd = new Random();
        return Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
