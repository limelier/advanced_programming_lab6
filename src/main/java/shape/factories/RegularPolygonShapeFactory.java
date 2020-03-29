package shape.factories;

import shape.shapes.RegularPolygon;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.beans.PropertyChangeEvent;

/**
 * Allows the creation of regular polygons of a given radius and number of sides at some coordinates.
 */
public class RegularPolygonShapeFactory implements ShapeFactory {
    public int radius;
    public int sides;

    public RegularPolygonShapeFactory(int sides, int radius) {
        this.radius = radius;
        this.sides = sides;
    }

    @Override
    public Shape getShape(int x, int y) {
        return new RegularPolygon(x, y, radius, sides);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSpinner spinner = (JSpinner) e.getSource();
        int value = (int) spinner.getValue();
        String name = spinner.getName();

        if (name.equals("sides")) {
            sides = value;
        } else if (name.equals("size")) {
            radius = value;
        }
    }
}
