package ui.options;

import ui.MainFrame;

import javax.swing.*;

public class EllipseOptionsPanel extends OptionsPanel {
    JLabel widthLabel;
    JSpinner widthField;
    JLabel heightLabel;
    JSpinner heightField;

    public EllipseOptionsPanel(MainFrame frame, int width, int height) {
        super(frame);
        init(width, height);
    }

    private void init(int sides, int size) {
        widthLabel = new JLabel("Ellipse width:");
        widthField = new JSpinner(new SpinnerNumberModel(sides, 1, 200, 1));
        widthField.setName("width");

        heightLabel = new JLabel("Ellipse height:");
        heightField = new JSpinner(new SpinnerNumberModel(size, 1, 200, 1));
        heightField.setName("height");

        add(widthLabel);
        add(widthField);
        add(heightLabel);
        add(heightField);

        super.addColorControls();

        widthField.addChangeListener(frame.shapeController.getFactory());
        heightField.addChangeListener(frame.shapeController.getFactory());
    }
}
