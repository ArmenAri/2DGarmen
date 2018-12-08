package io.github.armenari.garmen.objects;

import io.github.armenari.garmen.graphics.GGraphics;
import io.github.armenari.garmen.graphics.GTexture;
import io.github.armenari.garmen.utils.GDefines;

import java.awt.*;

public class GObject {

    protected int ID;
    protected float x;
    protected float y;
    protected int sizeX;
    protected int sizeY;
    protected boolean rigid;
    protected GTexture texture;

    /**
     * @param ID
     * @param x
     * @param y
     * @param sizeX
     * @param sizeY
     * @param rigid
     * Game object with dimensions ID and rigidity
     */
    public GObject(int ID, float x, float y, int sizeX, int sizeY, boolean rigid) {
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY= sizeY;
        this.rigid = rigid;
    }

    /**
     * Update the game object
     */
    public void update() {

    }

    /**
     * Render the game object
     */
    public void render() {
        if(texture != null) {
            GGraphics.renderImage(texture, x, y, sizeX, sizeY, GDefines.WHITE);
        } else {
            GGraphics.renderQuad(x, y, sizeX, sizeY, GDefines.WHITE);
        }
    }

    public boolean isCollision(GObject o) {
        if(o.isRigid()) {
            if (this.getBounds().intersects(o.getBounds())) {
                return true;
            }
        }
        return false;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public boolean isRigid() {
        return rigid;
    }

    public void setRigid(boolean rigid) {
        this.rigid = rigid;
    }

    public GTexture getTexture() {
        return texture;
    }

    public GObject setTexture(GTexture texture) {
        this.texture = texture;
        return this;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, sizeX, sizeY);
    }
}
