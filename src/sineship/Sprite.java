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

    public BufferedImage sprImage;
    
    
    public int leftTrim =0;
    public int rightTrim =0;
    
    public int topTrim =0;
    public int bottomTrim;
    
    
    public Sprite(BufferedImage img){
      
        sprImage = img;
        this.setBounds(0, 0, 0, 0);
    }
    public Sprite(){
    this.setBounds(0, 0, 0, 0);
}
    
    public void asignImage(BufferedImage img){
        sprImage = img;
    }
    
    public void setTrim(int left, int right, int top, int bottom){
        leftTrim = left;
        rightTrim =right;
        topTrim = top;
        bottomTrim = bottom;
    }
    
    public void drawSprite(Graphics2D g,  int xPos, int yPos, int width, int height, boolean drawBounds){
        this.setBounds(xPos-leftTrim, yPos-topTrim, width+rightTrim, height+bottomTrim);
        g.drawImage(sprImage, xPos,yPos, width, height ,null);
        
        if(drawBounds) drawBounds(g);
        
    }
    
    public void drawBounds(Graphics2D g){
        g.draw(this);
    }
    
}
