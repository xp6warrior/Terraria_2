package general;

import javax.swing.*;

public abstract class Clock {
    static GamePanel window;

    public static void initialiseGame() {
        window = new GamePanel();

        // Initialising frame
        JFrame frame = new JFrame("Terraria 2");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Terraria 2");

        frame.add(window);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public static void startClock(int FPS) {
        double nanosPerFrame = (1000000000d/FPS);
        double previousTime = System.nanoTime();

        while (true) {
            if (System.nanoTime() - previousTime >= nanosPerFrame) {

                // Repaints the window once per frame
                window.repaint();

                previousTime = System.nanoTime();
            }
        }
    }

    public static void main(String[] args) {
        initialiseGame();
        startClock(60);
    }
}
