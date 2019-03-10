/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagraphicstemplate;

import java.awt.Color;

/**
 *
 * @author intern2
 */
public class BaseObjectBounds {

    int x, width;
    static int y, height;
    Color color;

    public BaseObjectBounds() {
        this.x = 0;
        BaseObjectBounds.y = 0;
        BaseObjectBounds.height = 0;
        this.width = 0;
        color = new Color(0, 0, 0);
    }

    public BaseObjectBounds(int x, int y, int height, int width, Color color) {
        this.x = x;
        BaseObjectBounds.y = y;
        BaseObjectBounds.height = height;
        this.width = width;
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        BaseObjectBounds.y = y;
    }

    public void setHeight(int height) {
        BaseObjectBounds.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }
}
