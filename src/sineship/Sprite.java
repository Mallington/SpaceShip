/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sineship;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author 160471
 */
public class Sprite extends Rectangle{

    
    
    public Sprite(){
      
        this.setBounds(0, 0, 0, 0);
    }
    
    public void drawSprite(Graphics2D g, BufferedImage img, int xPos, int yPos, int width, int height){
        this.setBounds(xPos, yPos, width, height);
        g.drawImage(img, xPos,yPos, width, height ,null);
    }
    
}
