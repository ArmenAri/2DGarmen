package io.github.armenari.garmen.main;

import io.github.armenari.garmen.fx.GParticle;
import io.github.armenari.garmen.game.GGame;
import io.github.armenari.garmen.graphics.GButton;
import io.github.armenari.garmen.graphics.GGui;
import io.github.armenari.garmen.graphics.GTexture;
import io.github.armenari.garmen.utils.GDefines;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;

public class Game extends GGame {

    public static ArrayList<GParticle> particles = new ArrayList<GParticle>();
    public static ArrayList<GButton> buttons = new ArrayList<GButton>();

    GGui gui1 = new GGui(0, "Inventory", 100, 100, 400, 100);
    GGui gui2 = new GGui(0, "Map", 0, 0, 300, 100);

    public Game() {

    }

    public void update() {
        gui1.update();
        gui2.update();
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
