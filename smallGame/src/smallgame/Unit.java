/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallgame;

import com.google.common.util.concurrent.AtomicDouble;

/**
 *
 * @author Serhiy
 */
public class Unit implements Comparable{
    AtomicDouble health = new AtomicDouble(100.0);
    int id;
    int damageDone;
    
    public Unit(int id){
        this.id = id;
    }
    public void setDamageDone(double damage){
        damageDone += damage;
    }
    
    public AtomicDouble getHealth(){
        return health;
    }
    public void damage(double damage){
        if(getHealth().get() > 0.0){
            health.addAndGet(-damage);
            System.out.println("unit[" + this.id + "] was " + getHealth() + " HP");
        }else{
            System.out.println("unit["+this.id+"] is dead");
        }
    }

    @Override
    public int compareTo(Object o) {
        Unit tmp = (Unit)o;
    if(this.damageDone < tmp.damageDone)
    {
      
      return -1;
    }   
    else if(this.damageDone > tmp.damageDone)
    {
      
      return 1;
    }
    
    return 0;  
  }
}

