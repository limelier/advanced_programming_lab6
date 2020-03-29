package ui.options;

import javax.swing.*;

public abstract class OptionsPanel extends JPanel {
    JLabel colorLabel;
    JComboBox<String> colorCombo; // the color of the shape


    public boolean getColorIsRandom() {
        return (colorCombo.getSelectedItem() == "Random");
    }

}
