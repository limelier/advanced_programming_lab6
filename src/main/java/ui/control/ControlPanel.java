package ui.control;

import ui.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.getImage(), "PNG", new File("test_saves/test.png"));
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }

    private void load(ActionEvent e) {
        try {
            frame.canvas.load(ImageIO.read(new File("test_saves/test.png")));
            frame.repaint();
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }

    private void reset(ActionEvent e) {
        frame.canvas.reset();
        frame.repaint();
    }

    private void exit(ActionEvent e) {
        frame.exit();
    }
}
