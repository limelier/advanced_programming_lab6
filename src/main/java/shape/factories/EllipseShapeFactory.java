package shape.factories;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class EllipseShapeFactory implements ShapeFactory {
    private int width;
    private int height;

    public EllipseShapeFactory(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private int getCenterX(int cornerX) {
        return cornerX - (width / 2);
    }

    private int getCenterY(int cornerY) {
        return cornerY - (height / 2);
    }

    @Override
    public Shape getShape(int x, int y) {
        return new Ellipse2D.Float(getCenterX(x), getCenterY(y), width, height);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSpinner spinner = (JSpinner) e.getSource();
        int value = (int) spinner.getValue();
        String name = spinner.getName();

        if (name.equals("width")) {
            width = value;
        } else if (name.equals("height")) {
            height = value;
        }
    }
}
