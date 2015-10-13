
package oop1;


public class Person extends BaseUnit implements Moveble {
   
    Point position;
    
    public Person(int id) {
        super(id);
    }
     public Person(int id , Point pos) {
        super(id);
        position = pos;
    }
    @Override
    public String info() {
        return "";
    }

    @Override
    public void move(Point distanse) {
        position.add(distanse);
    }
    
    @Override
   public String toString(){
       return"["+id+"]  (" + position + ")" ;
   } 
   
   final public String getName(){
       return "Vasya Pupkin";
   }
}
