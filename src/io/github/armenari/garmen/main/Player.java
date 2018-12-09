package io.github.armenari.garmen.main;

import io.github.armenari.garmen.objects.GObject;
import org.lwjgl.input.Keyboard;

public class Player extends GObject {

    private float friction = 0.07f;
    private float dx, dy, speed = 1.5f;

    public Player(int ID, float x, float y, int sizeX, int sizeY, boolean rigid) {
        super(ID, x, y, sizeX, sizeY, rigid);
    }

    @Override
    public void update() {
        if(!this.isOutOfWindowBound()) {
            if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
                dy -= speed;
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
                dx -= speed;
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
                dy += speed;
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
                dx += speed;
            }
            dx *= (1 - friction);
            dy *= (1 - friction);
        } else {
            dx = -dx;
            dy = -dy;
        }
        x += dx;
        y += dy;
    }
}
