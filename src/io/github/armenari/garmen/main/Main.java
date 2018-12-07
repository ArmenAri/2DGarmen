package io.github.armenari.garmen.main;

import io.github.armenari.garmen.components.GWindow;
import io.github.armenari.garmen.utils.GDefines;

public class Main {

    static Game game;
    static GWindow window;
    public static void main(String[] args) {
        window = new GWindow(GDefines.WIDTH, GDefines.HEIGHT, GDefines.TITLE);
        game = new Game();
        window.start(game);
    }
}
