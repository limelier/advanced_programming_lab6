package ui.control;

import ui.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
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
    JButton undoBtn = new JButton("Undo");
    JButton redoBtn = new JButton("Redo");
    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());


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
        add(undoBtn);
        add(redoBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        undoBtn.addActionListener(this::undo);
        redoBtn.addActionListener(this::redo);
    }

    private void save(ActionEvent e) {
        try {
            if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                ImageIO.write(frame.canvas.getImage(), "PNG", selectedFile);
            }
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }

    private void load(ActionEvent e) {
        try {
            if (jfc.showDialog(this, "Load") == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                frame.canvas.load(ImageIO.read(selectedFile));
                frame.repaint();
            }

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
        frame.repaint();
    }

    private void undo(ActionEvent e) {
        frame.canvas.undo();
        frame.repaint();
    }

    private void redo(ActionEvent e) {
        frame.canvas.redo();
        frame.repaint();
    }
}
