import java.awt.*;
import java.util.Random;

public class Util {
    static Random random = new Random();

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
}
