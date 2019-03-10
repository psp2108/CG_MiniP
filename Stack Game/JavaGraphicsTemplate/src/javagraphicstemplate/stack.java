/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagraphicstemplate;

import java.awt.Color;

class stack {

    Node top;
    Node tempTraverser;

    static int y;
    static int height;

    stack() {
        top = null;
    }

    public void push(BaseObjectBounds baseObject) {
        Node newnode = new Node();
        newnode.link = top;
        newnode.rect = baseObject;
        top = newnode;
    }
    
    public void push(int x, int y, int Width, int Height, Color color) {
        Node newnode = new Node(x, Width, color);
        newnode.link = top;
        newnode.rect.setY(y);
        newnode.rect.setHeight(Height);
        top = newnode;
    }

    public BaseObjectBounds pop() {
        Node temp = top; // temporary variable that points to top
        top = top.link;	// moves to next NODE

        return temp.returnObject();	// return number
    }

    public void resetTempTraverser() {
        tempTraverser = top;
    }

    public BaseObjectBounds getTop(){
        return top.rect;
    }
    
    public BaseObjectBounds getNext() {
        Node temp = tempTraverser;

        
        if (tempTraverser != null) {
            tempTraverser = tempTraverser.link;
            return temp.returnObject();
        } else {
            return null;
        }
    }

    boolean isempty() {
        return (top == null);
    }

}
