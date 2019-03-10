/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagraphicstemplate;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 023627
 */
public class Ship {

    int x = 0;
    int y = 0;
    Graphics g;
    Color color;

    Ship(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setShipColor(Color color) {
        this.color = color;
    }

    public Graphics getColor(Graphics g) {

        g.setColor(color);

        return g;
    }

    public int returnx() {
        return this.x;
    }

    public int returny() {
        return this.y;
    }

}
