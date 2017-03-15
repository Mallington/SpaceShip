/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sineship;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author mathew
 */
public class StageMaster{

    /**
     *
     * @param stage
     * @param gInstance
     */

    public BufferedImage ship;
    public BufferedImage ship_fire;
    public BufferedImage BackGround;
    
    public int xPos =0;
    
    
    
    public GamePane stage;
    public StageMaster(GamePane stage){
        this.stage = stage;
        try{
       ship = ImageIO.read(this.getClass().getResourceAsStream("/res/ship(2).png"));
       ship_fire = ImageIO.read(this.getClass().getResourceAsStream("/res/ship_fire(2).png"));
       
       BackGround = ImageIO.read(this.getClass().getResourceAsStream("/res/BackGround.jpg"));
       
        } 
        catch(Exception e){System.out.println("Failed to find image");}
  }  
    
 
            public  void drawSpaceShip(Graphics2D g, int yLoc){
                 g.drawImage(BackGround, -750,-250,BackGround.getWidth()/2, BackGround.getHeight()/2,null);
                
                BufferedImage toDraw;
                if(Math.random()>0.5) toDraw = ship;
                
                else toDraw = ship_fire;
                
                Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                g.setStroke(dashed);
                g.setColor(Color.white);
                
                g.drawLine(0, 0, (stage.getWidth()/2)+xPos, yLoc);
                g.drawLine(stage.getWidth(),0 , (stage.getWidth()/2)+xPos, yLoc);
                
                g.drawLine(0, stage.getHeight(), (stage.getWidth()/2)+xPos, yLoc); 
                
                  g.drawLine(stage.getWidth(),stage.getHeight() , (stage.getWidth()/2)+xPos, yLoc);
                
                
              
                g.drawImage(toDraw, (stage.getWidth()/2)-(ship.getWidth()/8)+xPos,yLoc,ship.getWidth()/4, ship.getHeight()/4,null);
            }
            

  
}
