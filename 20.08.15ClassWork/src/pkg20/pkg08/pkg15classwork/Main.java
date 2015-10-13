
package pkg20.pkg08.pkg15classwork;


public class Main {

    
    public static void main(String[] args) {
        Unit horce = new HorseUnit(20);
        Unit warrior = new WarriorUnit("Kakoy-to chuvak");
        Informer i = new Informer();
        i.add(horce);
        i.add(warrior);
        i.add(new HorseUnit(40));
        System.out.println(i.info());
    }
    
}
