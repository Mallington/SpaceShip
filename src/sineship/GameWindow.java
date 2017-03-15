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
import javax.swing.*;
public class GameWindow extends JFrame

{   
    
    
    public GamePane panel;
   
    public GameWindow(int width, int height){
        this.setSize(width, height);
        panel = new GamePane(width,height);
        panel.addKeyListener(k);
        panel.setFocusable(true);
        panel.setEnabled(true);
        this.setResizable(false);
        this.add(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }
    public KeyListener k = new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
           
           if(e.getKeyChar()==32){
               System.out.println("toggling");
               panel.toggle();
           }
           if(e.getKeyChar() =='a'){
               panel.stageMaster.xPos-=10;
           }
            if(e.getKeyChar() =='d'){
               panel.stageMaster.xPos+=10;
           }
            
            
          if(e.getKeyChar()=='w'||e.getKeyChar()=='W') panel.itteration++;
           if(e.getKeyChar()=='s'||e.getKeyChar()=='S') panel.itteration--;
           
           
           
        }

        @Override
        public void keyReleased(KeyEvent e) {
          
        }
    };
    
    
    
    
    
    
   
    
    
}
