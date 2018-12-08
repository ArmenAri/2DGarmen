package io.github.armenari.garmen.graphics;

import io.github.armenari.garmen.objects.GObject;
import io.github.armenari.garmen.utils.GDefines;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import javax.swing.*;

public abstract class GButton extends GObject {

    private String text;
    private int textSize;
    private boolean isMouseDown;

    public GButton(String text, float x, float y) {
        super(0, x, y, 0, 30, false);
        this.text = text;
        textSize = 16;
        this.setSizeX(text.length() * textSize + textSize);
    }

    public boolean isButtonDown() {
        if(getBounds().contains(Mouse.getX(), Display.getHeight() - Mouse.getY()) && Mouse.isButtonDown(0) && !isMouseDown) {
            isMouseDown = true;
            return true;
        }
        if(!Mouse.isButtonDown(0)) {
            isMouseDown = false;
        }
        return false;
    }

    public boolean isButtonHover() {
        if(getBounds().contains(Mouse.getX(), Display.getHeight() - Mouse.getY())) {
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
        if(isButtonHover()) {
            GGraphics.renderQuad(x, y, sizeX, sizeY, GDefines.LIGHT_BLUE);
        }
        if(isButtonDown()) {
            GGraphics.renderQuad(x, y, sizeX, sizeY, GDefines.BLUE);
        }
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
