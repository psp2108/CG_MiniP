/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Pratik Panchal
 */
class DrawPanel extends JPanel {

    DrawPanel() {
        super();
        this.setBackground(Color.WHITE);
        this.add(new JLabel("Test"));
        System.out.println("In Constructor");
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("In Paint");
        
//        g.setColor(Color.WHITE);
//        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.RED);
        g.fillRect(10, 10, 100, 100);
    }
}
