package ui;

import ui.canvas.DrawingPanel;
import ui.control.ControlPanel;
import ui.options.RegularPolygonOptionsPanel;

import javax.swing.*;
import java.awt.*;

/**
 * The main frame of the application, holds the other ones.
 */
public class MainFrame extends JFrame {
    public RegularPolygonOptionsPanel optionsPanel;
    public ControlPanel controlPanel;
    public DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    /**
     * Instantiate and add the three components.
     */
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        optionsPanel = new RegularPolygonOptionsPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);

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
