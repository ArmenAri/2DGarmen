package io.github.armenari.garmen.fx;

import io.github.armenari.garmen.graphics.GGraphics;
import io.github.armenari.garmen.objects.GObject;
import io.github.armenari.garmen.utils.GDefines;
import org.lwjgl.Sys;
import org.lwjgl.util.vector.Vector2f;

import java.util.Random;

public class GParticle extends GObject {

    private Vector2f direction;
    private float lifetime;

    private float[] color;

    private float speed;

    public GParticle(int ID, float x, float y, int size) {
        super(ID, x, y, size, size, false);
    }

    @Override
    public void update() {
        double gaussianX = new Random().nextGaussian();
        double gaussianY = new Random().nextGaussian();

        x += (direction.x + gaussianX) * speed;
        y += (direction.y + gaussianY) * speed;

        this.lifetime -= 0.01f;
    }

    @Override
    public void render() {
        if(texture != null) {
            GGraphics.renderOffsetImage(texture, x, y, sizeX, sizeY, color, ID * 128, 0, 128, 128);
        } else {
            GGraphics.renderQuad(x, y, sizeX, sizeY, color);
        }
    }

    public float getLifetime() {
        return lifetime;
    }

    public void setLifetime(float lifetime) {
        this.lifetime = lifetime;
    }

    public Vector2f getDirection() {
        return direction;
    }

    /**
     * @param direction
     * @brief set the direction of the particle
     * @return the particle
     */
    public GParticle setDirection(Vector2f direction) {
        this.direction = direction;
        return this;
    }

    public float[] getColor() {
        return color;
    }

    /**
     * @param color
     * @brief set the color of the particle
     * @return the particle
     */
    public GParticle setColor(float[] color) {
        this.color = color;
        return this;
    }

    public float getSpeed() {
        return speed;
    }

    /**
     * @param speed
     * @brief set the speed of the particle
     * @return the particle
     */
    public GParticle setSpeed(float speed) {
        this.speed = speed;
        return this;
    }
}