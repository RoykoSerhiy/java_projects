
package lesson2syntax;

import oop1.Game;


public class Lesson2syntax {

    
    public static void main(String[] args) {
        oop();
    }
    public static void arrStr(String[] args) {
       Integer i = 1;
       String s = "string";
       char c = 'a';
       double d = 2.5;
       boolean b = true;
       
       TestArrays.arraysMethods();
       Unit unit = new Unit(123,100.0,true);
        System.out.println(unit);
        
        StringActions.speedTest();
    }
    public static void oop(){
        Game game = new Game();
        game.moveUnit(0, 10.0 , 25.0);
        System.out.println(game.unitInfo(0));
    }
    
}
