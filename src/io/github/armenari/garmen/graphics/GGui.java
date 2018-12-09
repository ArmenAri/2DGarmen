package io.github.armenari.garmen.graphics;

import io.github.armenari.garmen.objects.GObject;
import io.github.armenari.garmen.utils.GDefines;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import javax.swing.*;
import java.awt.*;

public class GGui extends GObject {

    private boolean guiOpened = true;
    private GuiCloseButton closeButton;
    private String name;

    /**
     * @param ID the id of the GUI
     * @param name the name that would be displayed on the top of the GUI
     * @param x the x position of the GUI
     * @param y the y position of the GUI
     * @param sizeX the horizontal size of the GUI
     * @param sizeY the vertical size of the GUI
     */
    public GGui(int ID, String name, float x, float y, int sizeX, int sizeY) {
        super(ID, x, y, sizeX, sizeY, false);
        this.name = name;
        this.closeButton = new GuiCloseButton("x", x + sizeX - 32, y, this);
    }

    @Override
    public void update() {
        closeButton.update();
    }

    @Override
    public void render() {
        if (isGuiOpened()){
            GGraphics.renderQuad(x, y, sizeX, sizeY, new float[]{1, 1, 1, 1});
            GGraphics.renderQuad(x, y, sizeX, 30, GDefines.WHITE);
            GGraphics.renderText(name, x + (sizeX / 2) - name.length() * 16 / 2, y + 8, 16, GDefines.BLACK);
            closeButton.render();
        }
    }

    public boolean isGuiOpened() {
        return guiOpened;
    }

    public void setGuiOpened(boolean guiOpened) {
        this.guiOpened = guiOpened;
    }
}
