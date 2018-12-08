package io.github.armenari.garmen.main;

import io.github.armenari.garmen.graphics.GButton;

public class ExitButton extends GButton {

    public ExitButton(String text, float x, float y, int sizeX, int sizeY) {
        super(text, x, y, sizeX, sizeY);
    }

    @Override
    public void action() {
        System.out.println("Clicked !");
    }

}
