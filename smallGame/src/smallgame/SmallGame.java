
package smallgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SmallGame {

    public static Unit winner = null;;
   
    public static void main(String[] args) {
       
    
}
    public void start(){
         List<Unit> units = new ArrayList<>();
         List<Unit> pretendentToWin = new ArrayList<>();
        for(int i = 0;i<5;++i){
            units.add(new Unit(i));
        }
        List<Future> res = new ArrayList<>();
       ExecutorService exec = Executors.newFixedThreadPool(units.size());
       for(int i = 0;i<units.size();++i){
           res.add(exec.submit(new Fighting(units , i)));
       }
       
       try{
           exec.awaitTermination(3, TimeUnit.SECONDS);
           exec.shutdown();
           for(Future r : res){
               if(r.isDone()){
                 Unit u = (Unit)r.get();
                 
                 if(u.getHealth().get() > 0)
                 {
                   pretendentToWin.add(u);
                   System.out.println("Unit[" + u.id + "] " + u.getHealth() + " HP");
                 }else{
                     System.out.println("Unit[" + u.id + "] fell in battle");
                 }
           }
           
       }
       winner = getWinner(pretendentToWin);
               System.out.println(winner.id + " with damage:" + winner.damageDone + " wins");
           
        } catch (InterruptedException ex) {
            Logger.getLogger(SmallGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(SmallGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Unit getWinner(List<Unit> units){
        Unit[] unitsToWin = units.toArray(new Unit[units.size()]);
        Arrays.sort(unitsToWin);
        return unitsToWin[0];
    }
}
