package sineship;
/**
 * Write a description of class GameWindow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
public class GameWindow extends JFrame

{   
    BufferedImage icon;
    
    public GamePane panel;
   
    public GameWindow(int width, int height){
        this.setSize(width, height);
        panel = new GamePane(width,height);
        panel.addKeyListener(k);
        
        JTabbedPane tabs = new JTabbedPane();
        
       
       
      
        panel.setFocusable(true);
        panel.setEnabled(true);
        tabs.addTab("Game", panel);
        
        this.setResizable(false);
        tabs.add("Secondary",new JPanel());
        this.add(tabs);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
         panel.setSize(360, 710);
        
    }
    public KeyListener k = new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
           if (e.getKeyChar() =='d') {panel.debugMode = (!panel.debugMode); System.out.println("Debug Mode "+panel.debugMode);}
           if(e.getKeyChar()=='p'){
               System.out.println("toggling");
               panel.toggle();
           }
         
            
            
          if(e.getKeyChar()=='w'||e.getKeyChar()=='W')panel.spaceShip.y-=10;
           if(e.getKeyChar()=='s'||e.getKeyChar()=='S')panel.spaceShip.y+=10;
           
           if(e.getKeyChar()==32){
               panel.idleTime =0;
               panel.incDebris =true;
           }

           
        }

        @Override
        public void keyReleased(KeyEvent e) {
          if(e.getKeyChar()==32) panel.incDebris =false;
        }
    };
    
    
    
    
    
     
   
    
    
}
