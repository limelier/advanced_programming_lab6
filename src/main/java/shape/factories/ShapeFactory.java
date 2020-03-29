package shape.factories;

import javax.swing.event.ChangeListener;
import java.awt.*;

public interface ShapeFactory extends ChangeListener {
    Shape getShape(int x, int y);
}
