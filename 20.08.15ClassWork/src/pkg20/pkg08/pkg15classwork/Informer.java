
package pkg20.pkg08.pkg15classwork;

import java.util.ArrayList;
import java.util.List;


public class Informer<T extends Unit & equipment> {
    private ArrayList<T> units = new ArrayList<T>();
    double value;
    public void add(T unit){
        units.add(unit);
    }
    public String info(){
        String res = "";
        for(T unit : units){
            res += unit.info()+ "\n";
        }
        return res;
    }
    public <N extends Number> void setValue(N x){
        value = x.doubleValue();
    }
}
