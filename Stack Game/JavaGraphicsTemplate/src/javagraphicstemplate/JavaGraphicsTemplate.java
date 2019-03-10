/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagraphicstemplate;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Color;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import sun.audio.*;
import java.net.URL;

public class JavaGraphicsTemplate extends JApplet {

    static int height, width;
    static JLabel scoreLabel;

    public static void main(String[] a) {
        JFrame window = new JFrame();
        height = 460;
        width = 460;

        window.setSize(width, height);
        window.setBackground(Color.yellow);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.getContentPane().add(new MyAppClass(width, height));
        window.setVisible(true);

    }
}
