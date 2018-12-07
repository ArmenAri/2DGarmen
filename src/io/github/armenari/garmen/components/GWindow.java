package io.github.armenari.garmen.components;

import io.github.armenari.garmen.graphics.GGraphics;
import io.github.armenari.garmen.graphics.GRunnable;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.LWJGLException;

import java.awt.*;

public class GWindow extends GRunnable {

    private int width;
    private int height;
    private String title;

    public GWindow(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.display();
    }

    /**
     * Display the window with OpenGL context initialized !
     */
    public void display() {
        try {
            Display.setDisplayMode(new DisplayMode(this.width, this.height));
            Display.setTitle(this.title);
            Display.setVSyncEnabled(true);
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }
        GGraphics.init(this.width, this.height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
