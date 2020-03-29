package ui;

import shape.ShapeController;
import shape.factories.EllipseShapeFactory;
import shape.factories.RegularPolygonShapeFactory;
import ui.canvas.DrawingPanel;
import ui.control.ControlPanel;
import ui.options.EllipseOptionsPanel;
import ui.options.OptionsPanel;
import ui.options.RegularPolygonOptionsPanel;
import ui.tool.ToolPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * The main frame of the application, holds the other ones.
 */
public class MainFrame extends JFrame {
    public OptionsPanel optionsPanel;
    public ControlPanel controlPanel;
    public DrawingPanel canvas;
    public ShapeController shapeController;
    public ToolPanel toolPanel;

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
        toolPanel = new ToolPanel(this);

        add(optionsPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        add(toolPanel, BorderLayout.EAST);

        pack();
    }

    public void switchOptionsPanel(ActionEvent e) {
        remove(optionsPanel);
        ui.options.Panel panel = (ui.options.Panel) ((JButton) e.getSource()).getClientProperty("panel");
        switch (panel) {
            case Ellipse:
                shapeController.setFactory(new EllipseShapeFactory(100, 100));
                optionsPanel = new EllipseOptionsPanel(this, 100, 100);
                break;
            case RegularPolygon:
                shapeController.setFactory(new RegularPolygonShapeFactory(6, 50));
                optionsPanel = new RegularPolygonOptionsPanel(this, 6, 50);
                break;
        }
        add(optionsPanel, BorderLayout.NORTH);
        validate();
    }

    /**
     * Exit the application.
     */
    public void exit() {
        System.exit(0);
    }
}
