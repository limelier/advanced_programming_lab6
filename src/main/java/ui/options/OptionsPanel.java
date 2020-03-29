package ui.options;

import ui.MainFrame;

import javax.swing.*;

public abstract class OptionsPanel extends JPanel {
    final MainFrame frame;
    JLabel colorLabel;
    JComboBox<String> colorCombo; // the color of the shape

    protected OptionsPanel(MainFrame frame) {
        this.frame = frame;
    }

    protected void addColorControls() {
        colorLabel = new JLabel("Color:");
        colorCombo = new JComboBox<>();
        colorCombo.addItem("Random");
        colorCombo.addItem("Black");
        add(colorLabel);
        add(colorCombo);
    }

    public boolean getColorIsRandom() {
        return (colorCombo.getSelectedItem() == "Random");
    }

}
