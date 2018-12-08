package io.github.armenari.garmen.graphics;

import io.github.armenari.garmen.objects.GObject;
import io.github.armenari.garmen.utils.GDefines;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import javax.swing.*;

public abstract class GButton extends GObject {

    private String text;
    private int textSize;

    public GButton(String text, float x, float y, int sizeX, int sizeY) {
        super(0, x, y, sizeX, sizeY, false);
        this.text = text;
        textSize = 8;
    }

    public boolean isButtonDown() {
        if(getBounds().contains(Mouse.getX(), Display.getHeight() - Mouse.getY()) && Mouse.isButtonDown(0)) {
            return true;
        }
        return false;
    }

    @Override
    public void update() {
        if(isButtonDown()) {
            action();
        }
    }

    @Override
    public void render() {
        GGraphics.renderQuad(x, y, sizeX, sizeY, GDefines.WHITE);
        GGraphics.renderText(text, x + sizeX / 2 - text.length() * textSize / 2 , y + sizeY / 2 - textSize / 2, textSize, GDefines.BLACK);
    }

    public abstract void action();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
