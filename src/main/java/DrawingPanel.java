import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;

    BufferedImage image; // the offscreen image
    Graphics2D graphics; // the "tools" needed to draw the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
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
        setPreferredSize(new Dimension(W, H)); // not setsize b/c it might not fit?
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        int radius = frame.configPanel.getShapeSize();
        int sides = frame.configPanel.getShapeSides();
        Color color = frame.configPanel.getColorIsRandom() ? Util.randomColor() : Color.BLACK;
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    @Override
    public void update(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    void reset() {
        createOffScreenImage();
    }

    public void load(BufferedImage read) {
        image = read;
        graphics = image.createGraphics();
    }
}
