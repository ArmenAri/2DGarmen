package io.github.armenari.garmen.main;

import io.github.armenari.garmen.components.GWindow;
import io.github.armenari.garmen.utils.GDefines;

public class Main {

    public static void main(String[] args) {
        GWindow window = new GWindow(GDefines.WIDTH, GDefines.HEIGHT, GDefines.TITLE);
        window.start(new Game());
    }
}
