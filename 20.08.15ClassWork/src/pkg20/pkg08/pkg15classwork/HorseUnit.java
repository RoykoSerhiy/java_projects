
package pkg20.pkg08.pkg15classwork;


public class HorseUnit extends Unit {
    public Integer speed;
    public HorseUnit(Integer speed){
        this.speed = speed;
    }
    @Override
    public String info(){
        return "horse speed["+speed.toString()+"]";
    }
}
