
package pkg20.pkg08.pkg15classwork;


public class WarriorUnit extends Unit implements equipment {
    public String name;
    public WarriorUnit(String name){
        this.name = name;
    }
    @Override
    public String info(){
        return "unit name["+name+"]";
    }

    @Override
    public int defence() {
       return 11;
    }
}
