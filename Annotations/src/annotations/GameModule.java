
package annotations;

import java.util.ArrayList;
import java.util.List;

@ModuleUnits(units={Rabbit.class, Fox.class})
public class GameModule {
    List<Unit> units = new ArrayList<>();
    public void addUnits(Unit unit){
        units.add(unit);
       
    }
}
