package ui.tool;

import ui.MainFrame;
import ui.options.Panel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Flow;

public class ToolPanel extends JPanel {
    final MainFrame frame;

    static final Map<Panel, String> buttonNames = Map.of(
            Panel.Ellipse, "●",
            Panel.RegularPolygon, "⯂"
    );

    public ToolPanel(MainFrame frame) {
        this.frame = frame;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Tools:"));
        initButtons();
    }

    private void initButtons() {
        for (Panel panel : Panel.values()) {
            JButton button = new JButton(buttonNames.get(panel));
            button.putClientProperty("panel", panel);
            button.addActionListener(frame::switchOptionsPanel);
            add(button);
        }
    }
}
