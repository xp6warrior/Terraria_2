package core;

import interfaces.Updatable;

public class Clock implements Runnable {
    public static double drawTime;

    private static final int FPS = 60;
    private final Updatable[] updates;
    private final GamePanel gamePanel;

    public Clock(Updatable[] updates, GamePanel gamePanel) {
        this.updates = updates;
        this.gamePanel = gamePanel;

        Thread clockThread = new Thread(this);
        clockThread.start();
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        double nanosPerFrame = (1000000000d/FPS);
        double previousTime = System.nanoTime();

        while (true) {
            if (System.nanoTime() - previousTime >= nanosPerFrame) {

                // Updates
                for (Updatable u: updates) {
                    u.update();
                }

                // Repaints the window once per frame
                double paintTime = System.nanoTime();
                gamePanel.repaint();

                drawTime = System.nanoTime() - paintTime;
                previousTime = System.nanoTime();
            }
        }
    }
}
