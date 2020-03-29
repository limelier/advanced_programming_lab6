package shape.shapes;

import java.awt.*;

public class RegularPolygon extends Polygon {
    public RegularPolygon(int x0, int y0, int radius, int sides, double rotation) {
        double alpha = 2 * Math.PI / sides;
        for (int i = 0; i < sides; i++) {
            double x = x0 + radius * Math.cos(alpha * i + rotation);
            double y = y0 + radius * Math.sin(alpha * i + rotation);
            this.addPoint((int) x, (int) y);
        }
    }
}
