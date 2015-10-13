
package exceptionlesson;


public class ChainExceptions {
    public static void run(int x){
        try{
            Exception cause;
            switch(x)
            {
                case 1: cause = new CriticalDamageException();
                    break;
                case 2: cause = new NoFoodException(); 
                    break;
                default: cause = new Exception();    
            }
            DeadUnitException due = new DeadUnitException();
            due.initCause(cause);
            throw due;
        }
        catch(DeadUnitException ex)
        {
            System.out.println(ex.getCause());
        }
    }
}
class DeadUnitException extends Exception{
   
}
class CriticalDamageException extends Exception{
    CriticalDamageException()
    { 
        super("Critical damage");
    }
}
class NoFoodException extends Exception{
    NoFoodException()
    { 
        super("No food");
    }
}
