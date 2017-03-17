/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sineship;

import java.awt.Dimension;
import java.awt.Toolkit;



/**
 *
 * @author mathew
 */
public class SineShip {

    /**
     * @param args the command line arguments
     */
      public  static GameWindow mainUI;
    public static void main(String[] args) {
       
          mainUI = new GameWindow(380,720);
          Dimension screenSize =  Toolkit.getDefaultToolkit().getScreenSize();
          mainUI.setLocation((int)(screenSize.getWidth()/2) -(mainUI.getWidth()/2), (int)(screenSize.getHeight()/2) -(mainUI.getHeight()/2));
          mainUI.setVisible(true);
          
    }
    
}
