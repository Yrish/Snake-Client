package me.braysen.goodwin.game.managers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys, justPressed, justReleased, past;

    public KeyManager() {
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        past = new boolean[keys.length];
        justReleased = new boolean[keys.length];
    }

    public boolean isPressed(int keyCode) {
        if (keyCode < 0 || keyCode >= keys.length) {
            return false;
        }
        return keys[keyCode];
    }

    public boolean justPressed(int keyCode) {
        return justPressed[keyCode];
    }

    public void tick(Manager m) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i]) {
                justPressed[i] = keys[i] ^ past[i];
            } else {
                justPressed[i] = false;
                justReleased[i] = keys[i] ^ past[i];
            }
            past[i] = keys[i];
        }
    }

    public void dropJustPressed() {
        justPressed = new boolean[keys.length];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //not needed
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code < 0 || code >= keys.length) {
            return;
        }
        keys[code] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code < 0 || code >= keys.length) {
            return;
        }
        keys[code] = false;
    }
}
