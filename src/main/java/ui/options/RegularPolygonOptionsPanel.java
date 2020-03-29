package ui.options;

import ui.MainFrame;

import javax.swing.*;

public class RegularPolygonOptionsPanel extends OptionsPanel {
    final MainFrame frame;
    JLabel sidesLabel;
    JSpinner sidesField;

    JLabel sizeLabel;
    JSpinner sizeField;

    public RegularPolygonOptionsPanel(MainFrame frame, int sides, int size) {
        this.frame = frame;
        init(sides, size);
    }

    private void init(int sides, int size) {
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(sides, 3, 100, 1));
        sidesField.setName("sides");

        sizeLabel = new JLabel("Size of the shape:");
        sizeField = new JSpinner(new SpinnerNumberModel(size, 1, 100, 1));
        sizeField.setName("size");

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

        sidesField.addChangeListener(frame.shapeController.getFactory());
        sizeField.addChangeListener(frame.shapeController.getFactory());
    }
}
