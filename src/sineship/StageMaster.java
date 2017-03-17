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
    public BufferedImage crashed;
    
    public Sprite shipSpr;

    public Sprite debris;
    
    
    public GamePane stage;
    public StageMaster(GamePane stage){
        this.stage = stage;
        try{
            int i =1;
       ship = ImageIO.read(this.getClass().getResourceAsStream("/res/ship(1).png"));
            System.out.println(i++);
       ship_fire = ImageIO.read(this.getClass().getResourceAsStream("/res/ship_fire(1).png"));
            System.out.println(i++);
       BackGround = ImageIO.read(this.getClass().getResourceAsStream("/res/Background3.png"));
            System.out.println(i++);
       rock_double = ImageIO.read(this.getClass().getResourceAsStream("/res/Rock_Single.png"));
            System.out.println(i++);
       crashed = ImageIO.read(this.getClass().getResourceAsStream("/res/Crashed.png"));
            System.out.println(i);
            System.out.println("Images Loaded: "+i );
        } 
        catch(Exception e){System.out.println("Failed to find images ");}
        
        shipSpr = new Sprite();
        shipSpr.asignImage(ship);
        shipSpr.setTrim(-15, -30, -20, -50);
        
        debris = new Sprite();
        debris.setTrim(-10, -10, -10, -10);
        debris.asignImage(rock_double);
        
  }         
            public void drawScore(Graphics2D g, int score){
                g.drawString("Score: "+score, 10, 20);
            }
            
    
            public void crashedScreen(Graphics2D g){
                g.drawImage(crashed, 0,0,crashed.getWidth(),crashed.getHeight(),null);
            }
    
            public void drawBackground(Graphics2D g, int yLoc){
                  g.drawImage(BackGround, 0,yLoc,BackGround.getWidth(), BackGround.getHeight(),null);
                  g.drawImage(BackGround, 0,yLoc-BackGround.getHeight(),BackGround.getWidth(), BackGround.getHeight(),null);
            }
    
            
            
            public void drawSpaceDebris(Graphics2D g, int xLoc, int yLoc, boolean drawConstruct){
               // g.drawImage( rock_double, xLoc,yLoc, rock_double.getWidth()/4,  rock_double.getHeight()/4,null);
                debris.drawSprite(g, xLoc, yLoc, rock_double.getWidth()/4,  rock_double.getHeight()/4, drawConstruct);
            }
            
            
            public  void drawSpaceShip(Graphics2D g,int xLoc, int yLoc, boolean drawConstruct){
                 
 
                if(drawConstruct){
                  
                  g.drawLine(0, 0, (stage.getWidth()/2)+xLoc, yLoc);
                  g.drawLine(stage.getWidth(),0 , (stage.getWidth()/2)+xLoc, yLoc);
                  g.drawLine(0, stage.getHeight(), (stage.getWidth()/2)+xLoc, yLoc); 
                  g.drawLine(stage.getWidth(),stage.getHeight() , (stage.getWidth()/2)+xLoc, yLoc);
                  g.drawString("X: "+xLoc+" Y: "+yLoc, 50, 50);
                  
                  
                }
                  
               
                 if(Math.random()>0.5) shipSpr.asignImage(ship);
                 else shipSpr.asignImage(ship_fire);
                // g.drawImage(toDraw, (stage.getWidth()/2)-(ship.getWidth()/8)+xLoc,yLoc,ship.getWidth()/4, ship.getHeight()/4,null);
                 
                 shipSpr.drawSprite(g, (stage.getWidth()/2)-(ship.getWidth()/8)+xLoc,yLoc,ship.getWidth()/4, ship.getHeight()/4,drawConstruct);
            }
            

  
}
