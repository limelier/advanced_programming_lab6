package ui;

import shape.factories.RegularPolygonShapeFactory;
import shape.ShapeController;
import ui.canvas.DrawingPanel;
import ui.control.ControlPanel;
import ui.options.OptionsPanel;
import ui.options.RegularPolygonOptionsPanel;

import javax.swing.*;
import java.awt.*;

/**
 * The main frame of the application, holds the other ones.
 */
public class MainFrame extends JFrame {
    public OptionsPanel optionsPanel;
    public ControlPanel controlPanel;
    public DrawingPanel canvas;
    public ShapeController shapeController;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    /**
     * Instantiate and add the three components.
     */
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);
        shapeController = ShapeController.getInstance();

        shapeController.setFactory(new RegularPolygonShapeFactory(6, 50));
        optionsPanel = new RegularPolygonOptionsPanel(this, 6, 50);

        add(optionsPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
    }

    /**
     * Exit the application.
     */
    public void exit() {
        System.exit(0);
    }
}
