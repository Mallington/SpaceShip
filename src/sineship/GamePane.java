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
    
    public boolean incDebris = false;
    public int debris =0;
    public int debrisX =0;
    public int itteration =10;
    
    public boolean debugMode = false;
   
    public boolean crashed = false;
    
    public int score =0;
    
    public StageMaster stageMaster;
    public Graphics2D masterGraphics;
    public Image canvas = null;
    public Point spaceShip = new Point(this.getWidth()/2, this.getHeight()/2);
    public void paint(Graphics g){
        grabFocus();
        masterGraphics = (Graphics2D) g;
        
      
        if(incDebris) {
            score+=itteration;
            debris+=itteration;
        }
        
        if(sinVal>360 || sinVal<0) sinIt *=-1;
        
        if(debris>this.getHeight()){ 
            debrisX = (int) (Math.random()*this.getWidth());
            debris =0;}
        
        
       
        g.setColor(Color.white);
        
        
        
        if(stageMaster.shipSpr.intersects(stageMaster.debris)) g.setColor(Color.red);
        
        else g.setColor(Color.white);
        
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        masterGraphics.setStroke(dashed);
        
        
        spaceShip.x = (int) (Math.sin(sinVal)*130);
        
        
        stageMaster.drawBackground(masterGraphics, debris);
        stageMaster.drawSpaceDebris(masterGraphics,debrisX , debris, debugMode);
        stageMaster.drawSpaceShip(masterGraphics,(int)spaceShip.getX(),540, debugMode);
        Font trb = new Font("TimesRoman", Font.BOLD, 18);
        masterGraphics.setFont(trb);
        stageMaster.drawScore(masterGraphics, score);
      
        sinVal+=((double)sinIt/30);
               
                
                
          
                if(crashed) {
                    Font cr = new Font("TimesRoman", Font.BOLD, 30);
                    masterGraphics.setFont(cr); 
                    System.out.println("Score: "+score);
                    stageMaster.crashedScreen(masterGraphics);
                    masterGraphics.setColor(Color.RED);
                    masterGraphics.drawString(""+score, (this.getWidth()/2)+20, 127);
                    
                    
                    reset();
                    crashed = false;
                   
                }
                
              
        
    
        
        
    }
    
   public void reset(){
    sinVal =0;
    sinIt =1;
    score =0;
    incDebris = false;
    debris =0;
    debrisX =0;
    itteration =10;
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
                
                
               if(stageMaster.shipSpr.intersects(stageMaster.debris)) {
                   crashed = true;
                   repaint();
                   gameRunning = false;
                   
               }
               
               else repaint();
               
               
               
               
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
