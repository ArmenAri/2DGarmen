package io.github.armenari.garmen.tests;

import io.github.armenari.garmen.fx.GParticle;
import io.github.armenari.garmen.game.GGame;
import io.github.armenari.garmen.buttons.GButton;
import io.github.armenari.garmen.graphics.GTexture;
import io.github.armenari.garmen.guis.GGui;
import io.github.armenari.garmen.utils.GDefines;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.Random;

public class Game extends GGame {

    public static ArrayList<GParticle> particles = new ArrayList<GParticle>();
    public static ArrayList<GButton> buttons = new ArrayList<GButton>();

    GGui gui1 = new GGui(0, "Inventory", 100, 100, 400, 100);
    GGui gui2 = new GGui(0, "Map", 10, 10, 300, 100);

    Player pl = new Player(0, 500, 500, 32, 32, true);


    GButton b = new GButton("MAMA", 1000, 400) {
        @Override
        public void onClick() {
            System.out.println("MAMA");
        }
    };

    public Game() {
        buttons.add(b);
    }

    public void update() {
        GParticle p = new GParticle(new Random().nextInt(5), 1000, 0, new Random().nextInt(32));
        p.setColor(GDefines.WHITE);
        p.setSpeed(0.9f);
        p.setDirection(new Vector2f(0, 10));
        p.setLifetime(1);
        p.setTexture(GTexture.flares);
        particles.add(p);
        gui1.update();
        gui2.update();
        pl.update();
        for(int i = 0; i < particles.size(); i++) {
            if(particles.get(i).getLifetime() < 0) {
                particles.remove(i);
            }
            particles.get(i).update();
        }
        for(int i = 0; i < buttons.size(); i++) {
            buttons.get(i).update();
        }
    }

    public void render() {
        pl.render();
        gui1.render();
        gui2.render();
        for(GParticle p : particles) {
            p.render();
        }
        for(int i = 0; i < buttons.size(); i++) {
            buttons.get(i).render();
        }
    }
}
