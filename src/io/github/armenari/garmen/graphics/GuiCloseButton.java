package io.github.armenari.garmen.graphics;

public class GuiCloseButton extends GButton {

    private GGui gui;

    public GuiCloseButton(String text, float x, float y, GGui gui) {
        super(text, x, y);
        this.gui = gui;
    }

    @Override
    public void action() {
        gui.setGuiOpened(false);
    }
}
