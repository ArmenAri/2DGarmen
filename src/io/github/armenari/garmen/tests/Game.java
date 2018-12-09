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
    GGui gui1 = new GGui(0, "testGUI1", 100, 100, 400, 100);
    GGui gui2 = new GGui(0, "testGUI2", 10, 10, 300, 100);

    /*
        Test player
     */
    Player player = new Player(0, 500, 500, 32, 32, true);

    /*
        Test button
     */
    GButton button = new GButton("testbutton", 1000, 400) {
        @Override
        public void onClick() {
            System.out.println("testaction");
        }
    };

    public Game() {}

    public void update() {
        /*
            Test particle
        */
        GParticle p = new GParticle(new Random().nextInt(5), 1000, 0, new Random().nextInt(32));
        p.setColor(GDefines.WHITE);
        p.setSpeed(0.9f);
        p.setDirection(new Vector2f(0, 10));
        p.setLifetime(1);
        p.setTexture(GTexture.flares);

        /*
            Updating all the game objects
         */

        for(int i = 0; i < objects.size(); i++) {
            objects.get(i).update();
        }
    }

    public void render() {
        /*
            Rendering all the game objects
         */
        for(int i = 0; i < objects.size(); i++) {
            objects.get(i).render();
        }
    }
}
