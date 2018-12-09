package io.github.armenari.garmen.tests;

import io.github.armenari.garmen.fx.GParticle;
import io.github.armenari.garmen.game.GGame;
import io.github.armenari.garmen.buttons.GButton;
import io.github.armenari.garmen.graphics.GTexture;
import io.github.armenari.garmen.guis.GGui;
import io.github.armenari.garmen.objects.GObject;
import io.github.armenari.garmen.utils.GDefines;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.Random;

public class Game extends GGame {

    public static ArrayList<GObject> objects = new ArrayList<GObject>();

    /*
        Test GUI
     */
    GGui gui1 = new GGui(0, "testGUI1", 10, 120, 300, 100);
    GGui gui2 = new GGui(0, "testGUI2", 10, 10, 300, 100);

    /*
        Test player
     */
    Player player = new Player(0, 500, 500, 64, 64, true);

    /*
        Test button and particle
     */
    GButton button = new GButton("Create Particle", 800, 400) {
        @Override
        public void onClick() {
            for (int i = 0; i < 10; i++) {
                GParticle p = new GParticle(new Random().nextInt(5), x + sizeX / 2, y + sizeY / 2, new Random().nextInt(32));
                p.setColor(GDefines.WHITE);
                p.setSpeed(new Random().nextFloat());
                p.setDirection(new Vector2f((float)new Random().nextGaussian() * 2, (float)new Random().nextGaussian() * 2));
                p.setLifetime(new Random().nextFloat() * 2);
                p.setTexture(GTexture.flares);
            }
        }
    };

    public Game() {

    }

    public void update() {
        /*
            Updating all the game objects
         */
        for(int i = 0; i < objects.size(); i++) {
            GObject o = objects.get(i);
            o.update();
            if(o instanceof GParticle) {
                if(((GParticle) o).getLifetime() < 0) {
                    objects.remove(o);
                }
            }
        }
    }

    public void render() {
        /*
            Rendering all the game objects
         */
        for(int i = 0; i < objects.size(); i++) {
            GObject o = objects.get(i);
            o.render();
        }
    }
}
