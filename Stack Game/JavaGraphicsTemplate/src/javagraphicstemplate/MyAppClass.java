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
import java.util.Random;

/**
 *
 * @author 023627
 */
class MyAppClass extends JComponent {

    int x = 200;
    int y = 400;
    int xc = 0;
    int yc = 130;
    int baseHeight = 0;
    Graphics me = null;

    Ship myShip;

    final short LEFT = -1;
    final short RIGHT = 1;
    final short PERFECT_TIME = 2;
    final short ON_TIME = 1;

    int directionx = 1;

    int defaultWidth = 110;
    final int defaultHeight = 30;
    final int initialBaseHeight = 15;
    boolean W_Clicked = false;
    boolean initialSetup = true;
    stack StackObj;
    BaseObjectBounds rect;
    int heightCounter = 0;
    //Color color = null;
    int score = 0;
    boolean gameOver = false;
    boolean perfect = false;

    int perfectVisibleTime;
    int speed = 3;
    float perfectVisibleTimeSeconds = 1.5f;

    /* public class MyKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 'D') {
                x++;
            }
            if (e.getKeyCode() == 'C') {
                y++;
            }
            if (e.getKeyCode() == 'W') {
                y--;
            }
            if (e.getKeyCode() == 'A') {
                x--;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased=" + KeyEvent.getKeyText(e.getKeyCode()));
        }

    }*/
    public class MyMouseKeyboardListener implements MouseListener, KeyListener {

        public void mouseClicked(MouseEvent mouseEvent) {

        }

        public void mouseEntered(MouseEvent mouseEvent) {
        }

        public void mousePressed(MouseEvent mouseEvent) {
        }

        public void mouseReleased(MouseEvent mouseEvent) {
        }

        public void mouseExited(MouseEvent mouseEvent) {
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == 'w') {
                W_Clicked = true;   //Sets the W_Clicked flag whenever the w key is pressed
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    MyAppClass(int FrameWidth, int FrameHeight) {
        // maze 2 dimensional array	
        KeyListener listener = new MyMouseKeyboardListener();
        MouseListener mouselistener = new MyMouseKeyboardListener();
        addKeyListener(listener);
        addMouseListener(mouselistener);

        setFocusable(true);

        rect = null;

        myShip = new Ship(0, 0, getRandomColor());
//        yc = 100;
        StackObj = new stack();
        score = 0;
        calPerfectVisibleTime();
        baseHeight = FrameHeight - defaultHeight + 2 - initialBaseHeight;
        StackObj.push((FrameWidth - defaultWidth) / 2, baseHeight, defaultWidth, defaultHeight, getRandomColor());

    }

    //This method is used to calculate the duration of Perfect message
    public void calPerfectVisibleTime() {
        int timeInMillis = (int) perfectVisibleTimeSeconds * 1000;
        perfectVisibleTime = timeInMillis / speed;
    }

    //It draws the blocks below the ship
    public void drawStack(Graphics g) {
        heightCounter = 0;
        StackObj.resetTempTraverser();  //Reset the stack top pointer

        //returns the next block from the statck and exit when it is null
        while ((rect = StackObj.getNext()) != null) {

            g.setColor(rect.getColor());
            g.fillRect(rect.getX(), rect.getY() + heightCounter, rect.getWidth(), rect.getHeight());
            System.out.println(rect.getY());
            heightCounter += defaultHeight;

            //Blocks out of screen are not printed
            if (heightCounter > this.getHeight()) {
                break;
            }
        }
    }

    //It draws the perfect message on window
    public void drawPerfectDialog(Graphics g) {

        g.setColor(Color.BLUE);
        Font initialFont = g.getFont();
        Font stringFont = new Font("Calibri", Font.BOLD, 20);
        String perfectString = "(^_^) PERFECT (^_^)";

        FontMetrics metrics = g.getFontMetrics(stringFont);

        g.setFont(stringFont);
        g.drawString(perfectString, (this.getWidth() - metrics.stringWidth(perfectString)) / 2, (yc / 2) + 20);
        g.setFont(initialFont);

    }

    //It draws the game over message on window
    public void drawGameOver(Graphics g) {

        g.setColor(Color.RED);
        Font initialFont = g.getFont();
        Font stringFont = new Font("Calibri", Font.BOLD, 20);
        String perfectString = "(x_x) GAME OVER (x_x)";

        FontMetrics metrics = g.getFontMetrics(stringFont);

        g.setFont(stringFont);
        g.drawString(perfectString, (this.getWidth() - metrics.stringWidth(perfectString)) / 2, (yc / 2) + 50);
        g.setFont(initialFont);

    }

    //It draws the score message when the game is over
    public void drawScore(Graphics g) {

        g.setColor(Color.BLACK);
        Font initialFont = g.getFont();
        String tempScore = "Your Score is: " + score;

        FontMetrics metrics = g.getFontMetrics(initialFont);

        g.drawString(tempScore, (this.getWidth() - metrics.stringWidth(tempScore)) / 2, 50);

    }

    public void paint(Graphics g) {
//        me = g;

        drawStack(g);

        if (perfect) {  //Checks the perfect flag
            if (perfectVisibleTime > 0) {
                perfectVisibleTime--;
            } else {
                //Reset's the perfect flag and perfectVisibleTime variables
                perfect = false;
                calPerfectVisibleTime();
            }

            drawPerfectDialog(g);
        }

        //g.getColor(color);
        g = myShip.getColor(g);

        xc += directionx;

        /////////////////////////////////////////////////////////////////////
//        if(xc == (this.getWidth() - defaultWidth) / 2){
//            W_Clicked = true;
//        }
        /////////////////////////////////////////////////////////////////////
        
        myShip.move(xc, baseHeight - defaultHeight);

        if (!gameOver) {    //Checks the game over flag
            //If game is not over draw the moving ship and the moving object is rectangle in shape
            g.fillRect(myShip.returnx(), myShip.returny(), defaultWidth, defaultHeight);
        } else {
            //If game is over the display game over message and score
            drawGameOver(g);
            drawScore(g);
        }

        if (W_Clicked) {    //Checks when the 'w' key is pressed
            W_Clicked = false;  //Reset the W_Clicked flag

            xc = trimShip(xc, defaultWidth, StackObj.getTop());     //Retrives the updated x coordinate of the block which is under ship

            if (xc != -1) { //Checks if the game is over (i.e the ship is completely out of bounds)

                // color = getRandomColor();
                myShip.setShipColor(getRandomColor());

                if ((yc + defaultHeight) < baseHeight) {
                    baseHeight -= defaultHeight;
                }
                //It pushes the trimmed ship data (or its width and x Co-ordinate especially) into to stack, so that on next iteration of paint method it gets drawn on the window
                StackObj.push(xc, baseHeight, defaultWidth, defaultHeight, g.getColor());

            } else {
                //Game Over and sets the gameOver flag
                gameOver = true;
                repaint();
            }
        }

        // create a delay
        try {
            Thread.sleep(speed);
        } catch (InterruptedException ex) {
        }

        // bounce off of the right and left wall
        if (xc < 0) {
            directionx = RIGHT;
        }
        if (xc > this.getWidth() - defaultWidth) {
            directionx = LEFT;
        }

        if (!gameOver) {
            repaint();
        }
    }

    //It trims the ship when it in bounds of the base but not align perfectlt
    public int trimShip(int x1, int width1, BaseObjectBounds baseBounds) {
        //x1 is the x co-ordinate of ship
        //width1 is width of ship
        //x2 is x co-ordinate of base
        //width2 is width of base

        int x2;
        int width2;

        x2 = baseBounds.getX(); //Returns x coordinate of base from stack's top block
        width2 = baseBounds.getWidth();  //Returns width of base from stack's top block

        if (x1 != x2) { //check if the ship and base is perfectly aligned
            if (x1 < x2) {  //check if the ship is at the left of base
                if ((x1 + width1) < x2) {   //If it out of bounds of base
                    //Game Over
                    return -1;  //Returns -1 if the game is over
                } else {    //If it is bounds of base
                    defaultWidth = width2 - (x2 - x1);  //the width is calculated to trim the ship
                    x1 = x2;    //x co-ordinate of ship is updated to fit perfectly with the base
                    score += ON_TIME;   //Score is incremented by 1
                }
            } else {    //if the ship is at the left of base
                if ((x2 + width2) < x1) {   //If it out of bounds of base
                    //Game Over
                    return -1;  //Returns -1 if the game is over
                } else {    //If it is bounds of base
                    defaultWidth = width2 - (x1 - x2);  //the width is calculated to trim the ship and is assaigned to the global variable defaultWidth
                    score += ON_TIME;   //Score is incremented by 1
                }
            }
        } else {
            //Perfect
            score += PERFECT_TIME;  //Score is incremented by 2
            perfect = true; //Perfect flag is set to display the perfect message
        }
        return x1;  //Returns the updated x co-ordinate of ship
    }

    //It generated ramdom color
    public static Color getRandomColor() {
        int r, g, b;
        Random random = new Random();
        r = random.nextInt(255);
        g = random.nextInt(255);
        b = random.nextInt(255);
        return new Color(r, g, b);
    }
}
