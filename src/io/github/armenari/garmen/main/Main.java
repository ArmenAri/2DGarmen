package io.github.armenari.garmen.main;

import io.github.armenari.garmen.components.GWindow;
import io.github.armenari.garmen.game.GGame;
import io.github.armenari.garmen.utils.GDefines;

public class Main {

    public static void main(String[] args) {
        GGame game = new GGame();
        GWindow window = new GWindow(GDefines.WIDTH, GDefines.HEIGHT, GDefines.TITLE);
        window.start(game);
    }
}
