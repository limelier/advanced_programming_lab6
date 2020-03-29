package shape;

import shape.factories.RegularPolygonShapeFactory;
import shape.factories.ShapeFactory;

import java.awt.*;

/**
 * Singleton pattern.
 */
public class ShapeController {
    private static ShapeController instance = new ShapeController();

    public static ShapeController getInstance() {
        return instance;
    }

    private ShapeFactory factory;

    public void setFactory(ShapeFactory factory) {
        this.factory = factory;
    }

    public ShapeFactory getFactory() {
        return this.factory;
    }

    public Shape getShape(int x, int y) {
        return factory.getShape(x, y);
    }
}
