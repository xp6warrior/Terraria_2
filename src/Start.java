import core.*;
import interfaces.Drawable;
import interfaces.Updatable;

public class Start {
    public static void main(String[] args) {
        // Game components
        InputHandler input = new InputHandler();
        Camera camera = new Camera(input);
        TileRenderer renderer = new TileRenderer(camera);

        // Updatables and drawables
        Updatable[] updates = {camera};
        Drawable[] draws = {renderer};

        // GamePanel
        GamePanel gamePanel = new GamePanel(draws);
        gamePanel.addMouseListener(input);
        gamePanel.addKeyListener(input);

        // Initiate clock cycle
        new Clock(updates, gamePanel);
    }
}
