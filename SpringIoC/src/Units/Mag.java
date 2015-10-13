/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Units;

/**
 *
 * @author Serhiy
 */
public class Mag implements Unit{
    private String name;

     public Mag(String name){
        setName(name);
    }

    @Override
    public void doMission() {
        System.out.printf("Mag %s doing...\n" , name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
       this.name = name;
    }
}
