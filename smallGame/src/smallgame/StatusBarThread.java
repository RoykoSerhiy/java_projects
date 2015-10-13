/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallgame;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author Serhiy
 */
public class StatusBarThread extends Thread{
    
    JProgressBar bar;
    List<Fighting> fightings;
    public StatusBarThread(JProgressBar b , List<Fighting> fightings){
        this.bar = b;
        this.fightings = fightings;
    }
    
    @Override
    public void run(){
        try {
        while(bar.getValue() == bar.getMaximum()){
            Thread.sleep(100);
            for(Fighting f : fightings)    
            {
               bar.setValue(f.getCurrentIter());
            }
        }
        } catch (InterruptedException ex) {
                Logger.getLogger(StatusBarThread.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
