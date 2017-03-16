package sineship;
/**
 * Write a description of class GamePane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class GamePane extends JPanel implements Runnable
{
    
    
    public double sinVal =0;
    public int sinIt =1;
    
    
    public int itteration =1;
    
    public boolean debugMode = false;
   
    public StageMaster stageMaster;
    public Graphics2D masterGraphics;
    public Image canvas = null;
    public Point spaceShip = new Point(this.getWidth()/2, this.getHeight()/2);
    public void paint(Graphics g){
        grabFocus();
        if(sinVal>360 || sinVal<0) sinIt *=-1;
        
        masterGraphics = (Graphics2D) g;
        
        spaceShip.x = (int) (Math.sin(sinVal)*130);
        
        
        stageMaster.drawBackground(masterGraphics);
        stageMaster.drawSpaceShip(masterGraphics,(int)spaceShip.getX(),540, debugMode);
        
        
      
        sinVal+=((double)sinIt/30);
        
    }
    
    
   public void grabFocus(){
       this.setFocusable(true);
       this.setEnabled(true);
   }
    
    
   public boolean gameAlive = true;
   public boolean gameRunning = true;
   Thread mainThread;
  public GamePane(int width, int height){
      this.setSize(width, height);
      
      // masterGraphics = (Graphics2D) this.getGraphics();
      
      stageMaster = new StageMaster(this);
      canvas = createImage(55,55);
    
       
      //masterGraphics = (Graphics2D) canvas.getGraphics();
    
   
      mainThread = new Thread(this);
      mainThread.start();
    }
    
   
    
    
    
     public void run(){
         
        while(gameAlive){
            while(gameRunning){
                
               repaint();
                  try{ Thread.sleep(10);} catch(Exception e){}
            }
            try{ Thread.sleep(10);} catch(Exception e){}
        }
        System.exit(0);
         
    }
     
     
   public void toggle(){
       
       
       if(gameRunning) gameRunning = false;
       else gameRunning = true;
       System.out.println("Game Status: "+gameRunning);
       this.setToolTipText("Game Status: "+gameRunning);
   }
     
     
     
}
