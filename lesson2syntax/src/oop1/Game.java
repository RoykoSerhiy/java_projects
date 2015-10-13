
package oop1;


public class Game {
    Person[] units;
    final String generalIp;
    static int globalOption;
    {
        units = new Person[10];
    }
    static {
        globalOption = 47;
    }
    public Game(){
        generalIp = "10.0.0.230";
        for(int i = 0;i< units.length;++i){
            units[i] = new Person(100+i , new Point(10 + i,10 * i));
        }
    }
    
    public void moveUnit(int index , double x , double y){
        units[index].move(new Point(x , y));
    }
    
    public String unitInfo(int index){
        return units[index].toString();
    }
}
