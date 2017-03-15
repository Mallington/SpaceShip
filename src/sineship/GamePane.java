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
   
    public StageMaster stageMaster;
    public Graphics2D masterGraphics;
    public Image canvas = null;
    public int y =this.getHeight();
    public void paint(Graphics g){
        if(y<=0) y = this.getHeight();
        masterGraphics = (Graphics2D) g;
        
        
        
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        stageMaster.drawSpaceShip(masterGraphics,y);
        
        g.setColor(Color.green);
        g.drawString("Y: "+y, 50, y);
        y--;
       
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
