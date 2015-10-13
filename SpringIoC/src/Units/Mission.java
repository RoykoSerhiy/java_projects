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
public class Mission {
    private Mission(){
        
    }
    public static Mission getMission(){
        return new Mission();
    }
    public void start(){
        System.out.println("Mission is start.Try not die)");
    }
}
