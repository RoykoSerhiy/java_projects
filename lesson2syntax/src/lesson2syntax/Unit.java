
package lesson2syntax;


public class Unit {
    Integer id;
    Double value;
    Boolean isMain;
    
    public Unit(Integer id , Double value , Boolean isMain){
        this.id = id;
        this.value = value;
        this.isMain = isMain;
    }

    Unit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        return "["+id+"]"+"("+value+")" + (isMain ? "main" : "no main");
    }
}
