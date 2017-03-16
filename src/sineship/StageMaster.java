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
    public BufferedImage rock_double;
    

    
    
    
    public GamePane stage;
    public StageMaster(GamePane stage){
        this.stage = stage;
        try{
       ship = ImageIO.read(this.getClass().getResourceAsStream("/res/ship(1).png"));
       ship_fire = ImageIO.read(this.getClass().getResourceAsStream("/res/ship_fire(1).png"));
       
       BackGround = ImageIO.read(this.getClass().getResourceAsStream("/res/BackGround.jpg"));
       rock_double = ImageIO.read(this.getClass().getResourceAsStream("/res/Rock_Double.png"));
        } 
        catch(Exception e){System.out.println("Failed to find image");}
  }  
    
            public void drawBackground(Graphics2D g){
                  g.drawImage(BackGround, -750,-250,BackGround.getWidth()/2, BackGround.getHeight()/2,null);
            }
    
            
            
            public void drawSpaceDebris(Graphics2D g, int xLoc, int yLoc){
                g.drawImage( rock_double, xLoc,yLoc, rock_double.getWidth()/4,  rock_double.getHeight()/4,null);
            }
            
            
            public  void drawSpaceShip(Graphics2D g,int xLoc, int yLoc, boolean drawConstruct){
                 
 
                if(drawConstruct){
                  Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                  g.setStroke(dashed);
                  g.setColor(Color.white);
                  g.drawLine(0, 0, (stage.getWidth()/2)+xLoc, yLoc);
                  g.drawLine(stage.getWidth(),0 , (stage.getWidth()/2)+xLoc, yLoc);
                  g.drawLine(0, stage.getHeight(), (stage.getWidth()/2)+xLoc, yLoc); 
                  g.drawLine(stage.getWidth(),stage.getHeight() , (stage.getWidth()/2)+xLoc, yLoc);
                  g.drawString("X: "+xLoc+" Y: "+yLoc, 50, 50);
                }
                  
                 BufferedImage toDraw;
                 if(Math.random()>0.5) toDraw = ship;
                 else toDraw = ship_fire;
                 g.drawImage(toDraw, (stage.getWidth()/2)-(ship.getWidth()/8)+xLoc,yLoc,ship.getWidth()/4, ship.getHeight()/4,null);
            }
            

  
}
