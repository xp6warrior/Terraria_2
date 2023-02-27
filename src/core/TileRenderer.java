package core;

import interfaces.Drawable;

import java.awt.*;

public class TileRenderer implements Drawable {
    private final Camera camera;

    // Tilemap size settings
    private static final int TILEMAP_WIDTH = 30;
    private static final int TILEMAP_HEIGHT = 20;
    private static final int AMOUNT_OF_H_TILES = 25;

    private static final int TILE_SIZE = GamePanel.WIDTH / AMOUNT_OF_H_TILES;

    private static final int[][] tileMap = new int[TILEMAP_WIDTH][TILEMAP_HEIGHT];

    public TileRenderer(Camera camera) {
        this.camera = camera;
    }

    private void loadTileMap() {
        for (int col = 0; col < tileMap.length; col++) {
            for (int row = 0; row < tileMap[col].length; row++) {

                tileMap[col][row] = 0;

            }
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        for (int col = 0; col < tileMap.length; col++) {
            for (int row = 0; row < tileMap[col].length; row++) {

                if (row < 12) {
                    g2d.setColor(Color.lightGray);
                } else {
                    g2d.setColor(Color.green);
                }

                g2d.drawRect(col * TILE_SIZE - camera.camX, row * TILE_SIZE - camera.camY, TILE_SIZE, TILE_SIZE);
            }
        }
        g2d.setColor(Color.WHITE);
        g2d.drawString(String.valueOf(Clock.drawTime), 20, 20);
    }
}
