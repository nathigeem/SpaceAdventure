package com.space.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class KeyHandler implements KeyListener {
    private boolean moveUp = false;
    private boolean moveDown = false;
    private boolean moveLeft = false;
    private boolean moveRight = false;

    private final int moveSpeedLeft = 7;
    private final int moveSpeedUp = 5;
    private final int moveSpeedDown = 3;

    public KeyHandler (Player player) {

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (moveUp && moveDown) {
                    moveUp = false;
                    moveDown = false;
                }

                if (moveUp) player.setY(player.getY() - moveSpeedUp);
                if (moveDown) player.setY(player.getY() + moveSpeedDown);
                if (moveLeft) player.setX(player.getX() - moveSpeedLeft);
                if (moveRight) player.setX(player.getX() + moveSpeedLeft);
            }
        }, 0, 10);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            moveUp = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moveDown = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            moveUp = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moveDown = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moveLeft = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight = false;
        }
    }
}