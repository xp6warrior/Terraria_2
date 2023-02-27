package core;

import interfaces.Drawable;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    // WINDOW SIZE SETTINGS
    private static final int H_ASPECT = 16;
    private static final int V_ASPECT = 9;
    private static final int WIN_SCALE = 75;

    public static final int WIDTH = H_ASPECT * WIN_SCALE;
    public static final int HEIGHT = V_ASPECT * WIN_SCALE;

    private final Drawable[] draws;

    public GamePanel(Drawable[] draws) {
        this.draws = draws;
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);

        // Frame
        JFrame frame = new JFrame("Terraria 2");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Terraria 2");

        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Elements to repaint
        for (Drawable d: draws) {
            d.draw(g2d);
        }
    }
}
