/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorswing;

/**
 *
 * @author Serhiy
 */
public class Calculating {
    public int a;
    public int b;
    public int res;
    public String operator;
    
    public void calculate(){
        switch(operator){
            case "+": res = a + b;
                break;
            case "-": res = a - b;
                break;
            case "*": res = a * b;
                break;
            case "/": res = a / b;
                break;
                    
        }
            
    }
}
