package ui.canvas;

import ui.MainFrame;
import util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import static util.Image.copyImage;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;

    Deque<CanvasShape> activeDeque;
    Deque<CanvasShape> redoDeque;

    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        activeDeque = new ArrayDeque<>(10);
        redoDeque = new ArrayDeque<>(10);
        createOffScreenImage();
        init();
    }

    private void createOffScreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        Shape shape = frame.shapeController.getShape(x, y);
        Color color = frame.optionsPanel.getColorIsRandom() ? Random.randomColor() : Color.BLACK;
        CanvasShape canvasShape = new CanvasShape(shape, color);
        addToUndoStack(canvasShape);
    }

    private void addToUndoStack(CanvasShape shape) {
        if (activeDeque.size() == 50) {
            CanvasShape lastShape = activeDeque.removeLast();
            graphics.setColor(lastShape.color);
            graphics.fill(shape.shape);
        }
        activeDeque.add(shape);
    }

    private BufferedImage activeImage() {
        BufferedImage activeImage = copyImage(image);
        Graphics2D g = activeImage.createGraphics();
        for (Iterator<CanvasShape> it = activeDeque.descendingIterator(); it.hasNext(); ) {
            CanvasShape shape = it.next();
            g.setColor(shape.color);
            g.fill(shape.shape);
        }
        g.dispose();
        return activeImage;
    }

    @Override
    public void update(Graphics g) {
        g.drawImage(activeImage(), 0, 0, this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(activeImage(), 0, 0, this);
    }

    public void reset() {
        createOffScreenImage();
    }

    public void load(BufferedImage read) {
        image = read;
        graphics = image.createGraphics();
        activeDeque.clear();
        redoDeque.clear();
    }

    public BufferedImage getImage() {
        return image;
    }
}
