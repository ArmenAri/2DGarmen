package io.github.armenari.garmen.components;

import io.github.armenari.garmen.components.GWindow;
import io.github.armenari.garmen.game.GGame;
import io.github.armenari.garmen.graphics.GGraphics;
import io.github.armenari.garmen.utils.GDefines;
import org.lwjgl.opengl.Display;

public class GRunnable {

    /**
     * Main loop whit FPS calculator and frequencer
     * @param game that is included into the window
     */
    public static void start(GGame game) {
        long lastTime = System.nanoTime();
        double delta = 0.0;
        double ns = 1000000000.0 / GDefines.FPS;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while (!Display.isCloseRequested()) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1.0) {
                game.update();
                updates++;
                delta--;
            }
            game.render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(frames);
                updates = 0;
                frames = 0;
            }
            Display.update();
            GGraphics.clear();
        }
        Display.destroy();
        System.exit(0);
    }
}
