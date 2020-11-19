package com.exocorp.swingtech21.engine;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    public static JFrame f;

    public Window(int width, int height, String title, Core core){
        f = new JFrame(title);

        f.setPreferredSize(new Dimension(width, height));
        f.setMinimumSize(new Dimension(width, height));
        f.setMaximumSize(new Dimension(width, height));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocationRelativeTo(null);

        f.add(core);
        f.setVisible(true);
        core.start();
    }
}
