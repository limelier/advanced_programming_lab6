package ui.config;

import ui.MainFrame;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel; // we're drawing regular polygons
    JSpinner sidesField; // number of sides

    JLabel sizeLabel;
    JSpinner sizeField;

    JLabel colorLabel;
    JComboBox<String> colorCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

        sizeLabel = new JLabel("Size of the shape:");
        sizeField = new JSpinner(new SpinnerNumberModel(50, 1, 100, 1));

        colorLabel = new JLabel("Color:");
        colorCombo = new JComboBox<>();
        colorCombo.addItem("Random");
        colorCombo.addItem("Black");

        add(sidesLabel); // JPanel uses FlowLayout by default
        add(sidesField);
        add(sizeLabel);
        add(sizeField);
        add(colorLabel);
        add(colorCombo);
    }

    public int getShapeSides() {
        return (int) sidesField.getValue();
    }

    public int getShapeSize() {
        return (int) sizeField.getValue();
    }

    public boolean getColorIsRandom() {
        return (colorCombo.getSelectedItem() == "Random");
    }
}
