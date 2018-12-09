package io.github.armenari.garmen.buttons;

import io.github.armenari.garmen.graphics.GGraphics;
import io.github.armenari.garmen.objects.GObject;
import io.github.armenari.garmen.tests.Game;
import io.github.armenari.garmen.utils.GDefines;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public abstract class GButton extends GObject {

    private String text;
    private int textSize;
    private boolean isMouseDown;
    private boolean visible;

    /**
     * @param text the text that would be displayed on the button
     * @param x the x position of the button
     * @param y the y position of the button
     */
    public GButton(String text, float x, float y) {
        super(0, x, y, 0, 30, false);
        this.text = text;
        textSize = 16;
        this.setSizeX(text.length() * textSize + textSize);
        this.setVisible(true);
    }

    /**
     * @return true if the button is down (click) false if not
     */
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

    /**
     * @return true if the button is overflew by the mouse false if not
     */
    public boolean isButtonHover() {
        if(getBounds().contains(Mouse.getX(), Display.getHeight() - Mouse.getY())) {
            return true;
        }
        return false;
    }

    @Override
    public void update() {
        if(isButtonDown()) {
            onClick();
        }
    }

    @Override
    public void render() {
        if (isVisible()) {
            GGraphics.renderQuad(x, y, sizeX, sizeY, GDefines.WHITE);
            if (isButtonHover()) {
                GGraphics.renderQuad(x, y, sizeX, sizeY, GDefines.LIGHT_BLUE);
            }
            if (isButtonDown()) {
                GGraphics.renderQuad(x, y, sizeX, sizeY, GDefines.BLUE);
            }
            GGraphics.renderText(text, x + sizeX / 2 - text.length() * textSize / 2, y + sizeY / 2 - textSize / 2, textSize, GDefines.BLACK);
        }
    }

    /**
     * Called when the buttion is clicked down
     */
    public abstract void onClick();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
