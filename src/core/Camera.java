package core;

import interfaces.Updatable;

public class Camera implements Updatable {
    private final InputHandler input;

    // Parameters
    int camX = 0;
    int camY = 0;
    final int camWidth = GamePanel.WIDTH;
    final int camHeight = GamePanel.HEIGHT;

    public Camera(InputHandler input) {
        this.input = input;
    }

    @Override
    public void update() {
        if (input.up) {
            camY -= 10;
        }
        if (input.down) {
            camY += 10;
        }
        if (input.left) {
            camX -= 10;
        }
        if (input.right) {
            camX += 10;
        }
    }
}
