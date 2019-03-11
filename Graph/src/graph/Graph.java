/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Pratik Panchal
 */
public class Graph extends JFrame {

    JPanel panel = null;

    Graph() {
        this.setSize(300, 200);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new DrawPanel();
        this.add(panel,BorderLayout.CENTER);

        JButton b = new JButton("Draw");
        b.setBounds(100, 50, 50, 50);
        this.add(b,BorderLayout.SOUTH);
        
        this.setVisible(true);
        
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

    public static void main(String[] args) {
        new Graph();
    }
}
