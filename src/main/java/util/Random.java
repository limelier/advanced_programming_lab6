package util;

import java.awt.*;

public class Random {
    static java.util.Random random = new java.util.Random();

    public static int generateRadius() {
        return random.nextInt(60);
    }

    public static Color randomColor() {
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        float a = random.nextFloat();
        return new Color(r, g, b, a);
    }

    public static double randomAngle() {
        return random.nextFloat() * 2 * Math.PI;
    }
}
