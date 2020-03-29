package ui;

import ui.canvas.DrawingPanel;
import ui.config.ConfigPanel;
import ui.control.ControlPanel;

import javax.swing.*;
import java.awt.*;

/**
 * The main frame of the application, holds the other ones.
 */
public class MainFrame extends JFrame {
    public ConfigPanel configPanel;
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
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);

        add(configPanel, BorderLayout.NORTH);
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
