
package smallgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;


public class Fighting implements Callable{

    List<Unit> units = new ArrayList<>();
    int currUnitId;
    int currIteration;
    public Fighting(List<Unit> units , int currUnitId){
        this.units = units;
        this.currUnitId = currUnitId;
    }
    @Override
    public Object call() throws Exception {
        Random r = new Random();
        for(int i = 0;i<10;i++){
            double damage = r.nextInt(15);
            int user = r.nextInt(units.size());
            Thread.sleep(100);
            units.get(user).damage(damage);
            units.get(user).setDamageDone(damage);
            currIteration += 1 * 10;
        }
        return units.get(currUnitId);
    }
    public int getCurrentIter(){
        return currIteration;
    }
    
}
