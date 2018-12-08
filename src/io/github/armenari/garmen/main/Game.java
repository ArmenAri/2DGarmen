package io.github.armenari.garmen.main;

import io.github.armenari.garmen.fx.GParticle;
import io.github.armenari.garmen.game.GGame;
import io.github.armenari.garmen.graphics.GTexture;
import io.github.armenari.garmen.utils.GDefines;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;

public class Game extends GGame {

    public static ArrayList<GParticle> particles = new ArrayList<GParticle>();

    public Game() {

    }

    public void update() {
        GParticle p = new GParticle(0, Mouse.getX(), Display.getHeight() - Mouse.getY(), 10);
        p.setTexture(GTexture.flares);
        p.setLifetime(1);
        p.setDirection(new Vector2f(0, 0));
        p.setSpeed(2);
        p.setColor(GDefines.YELLOW);
        particles.add(p);
        for(int i = 0; i < particles.size(); i++) {
            if(particles.get(i).getLifetime() < 0) {
                particles.remove(i);
            }
            particles.get(i).update();
        }
    }

    public void render() {

        for(GParticle p : particles) {
            p.render();
        }
    }
}
