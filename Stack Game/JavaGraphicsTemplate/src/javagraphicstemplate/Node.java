/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagraphicstemplate;

import java.awt.Color;
import java.awt.Rectangle;

class Node {
        BaseObjectBounds rect;
	Node link;

	public BaseObjectBounds returnObject() {
            return rect;
	}	
	
        public Node(){}
        
	public Node(int x, int width, Color color){
                rect = new BaseObjectBounds();
		rect.setX(x);
		rect.setWidth(width);
                rect.setColor(color);
	}
	
}
