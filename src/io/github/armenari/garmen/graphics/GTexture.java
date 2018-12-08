package io.github.armenari.garmen.graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;

public class GTexture {

    public static final GTexture default_font = loadTexture("/fonts/default_font.png");
    public static final GTexture fire = loadTexture("/assets/particles/fire.png");
    public static final GTexture flares = loadTexture("/assets/particles/flares_set.png");

    private int width, height;
    private int id;

    public GTexture(int width, int height, int id) {
        this.width = width;
        this.height = height;
        this.setId(id);
    }

    /**
     * @param path the path of the asset
     * @return the texture with the asset
     */
    public static GTexture loadTexture(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(GTexture.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int w = image.getWidth();
        int h = image.getHeight();

        int[] pixels = new int[w * h];
        image.getRGB(0, 0, w, h, pixels, 0, w);

        ByteBuffer buffer = BufferUtils.createByteBuffer(w * h * 4);

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int pixel = pixels[x + y * w];
                buffer.put((byte) ((pixel >> 16) & 0xFF));
                buffer.put((byte) ((pixel >> 8) & 0xFF));
                buffer.put((byte) ((pixel) & 0xFF));
                buffer.put((byte) ((pixel >> 24) & 0xFF));
            }
        }

        buffer.flip();

        int id = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, id);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, w, h, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);

        return new GTexture(w, h, id);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void bind() {
        glBindTexture(GL_TEXTURE_2D, getId());
    }

    public void unbind() {
        glBindTexture(GL_TEXTURE_2D, 0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}