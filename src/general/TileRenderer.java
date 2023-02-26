package general;

import java.awt.*;

public abstract class TileRenderer {
    // TILEMAP SIZE SETTINGS
    static final int TILEMAP_WIDTH = 50;
    static final int TILEMAP_HEIGHT = 50;
    static final int AMOUNT_OF_H_TILES = 25;

    static final int[][] tileMap = new int[TILEMAP_WIDTH][TILEMAP_HEIGHT];
    static final int TILE_SIZE = GamePanel.H_ASPECT * GamePanel.WIN_SCALE / AMOUNT_OF_H_TILES;

    private static void loadTileMap() {
        for (int col = 0; col < tileMap.length; col++) {
            for (int row = 0; row < tileMap[col].length; row++) {

                tileMap[col][row] = 0;

            }
        }
    }

    public static void draw(Graphics2D g2d) {
        for (int col = 0; col < tileMap.length; col++) {
            for (int row = 0; row < tileMap[col].length; row++) {

                if (row < 12) {
                    g2d.setColor(Color.lightGray);
                } else {
                    g2d.setColor(Color.green);
                }

                g2d.drawRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }
}
