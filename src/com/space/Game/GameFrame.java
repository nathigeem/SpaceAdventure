package com.space.Game;

import com.space.Utility.DelayToFrameRate;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("InfiniteLoopStatement")
public class GameFrame {
    private static class Panel extends JPanel {
        Player player;

        public Panel(Player player) {
            this.player = player;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillRect(player.getX(), player.getY(), 100, 100);
            g.dispose();
        }
    }

    private static JFrame frame;

    public GameFrame() {
        DelayToFrameRate frameController = new DelayToFrameRate(60, true);
        Player player = new Player(590, 550);

        Panel panel = new Panel(player);

        frame = new JFrame();

        frame.add(panel);
        frame.addKeyListener(new KeyHandler(player));

        frame.setTitle("Space Adventure");
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.setBackground(Color.BLACK);

        while (true) {
            long time = System.nanoTime();
            panel.repaint();
            time = System.nanoTime() - time;
            frameController.delay(time);
        }
    }
}