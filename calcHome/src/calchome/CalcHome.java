
package calchome;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CalcHome {

    
    public static void main(String[] args) {
        calc();
    }
    public static void calc(){
        
        Scanner input= new Scanner(System.in);
        String str=input.nextLine();
        if("exit".equals(str)){
            System.out.println("shutdown");
            return;
        }
        //Pattern pattern = Pattern.compile("^[0-9]+\\s\\+\\-\\*\\/\\s[0-9]+$");
        //Matcher m = pattern.matcher(str);
        //if(m.find())
       // {
            String[] arr = str.split("\\s+");
            int a = Integer.parseInt(arr[0]);
            String act = arr[1];
            int b = Integer.parseInt(arr[2]);
            int res = 0;
        
            switch(act){
                case "+": res = a + b;
                    break;
                case "-": res = a - b;
                    break;
                case "*": res = a * b;
                    break;
                case "/": res = a / b;
                    break;
                default:
                   System.out.println("you enter frong symbols");
                   calc();
                   break;
                
            }
            System.out.println(res);
            calc();
        }
        //else
       // {
       //    System.out.println("you enter frong symbols try again");  
       //    calc();
       // }
        
        
    //}
    
}
