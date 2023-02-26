package general;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    // WINDOW SIZE SETTINGS
    static final int H_ASPECT = 16;
    static final int V_ASPECT = 9;
    static final int WIN_SCALE = 75;

    public GamePanel() {
        this.setPreferredSize(new Dimension(H_ASPECT * WIN_SCALE, V_ASPECT * WIN_SCALE));
        this.setBackground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        TileRenderer.draw(g2d);
    }
}
