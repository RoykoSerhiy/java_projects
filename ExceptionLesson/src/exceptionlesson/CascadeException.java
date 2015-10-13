
package exceptionlesson;


public class CascadeException {
    public static void test(){
        try{
            //throw new MyException1("exception 1");
            //throw new MyException2("exception 2");
            throw new Exception();
        }
        catch(MyException2 ex)
        {
            System.out.println(ex);
        }
        catch(MyException1 ex)
        {
            System.out.println(ex);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        finally{
            System.out.println("finally block");
        }
    }
    public static void subTest() throws MyException1{
        throw new MyException1("exception 1");
    }
    public static void multiCatch(int p){
        
        try
        {
            switch(p)
            {
                case 1:
                    throw new MyException("exc");
                case 2:
                    throw new MyException1("exc1");
                
            }
            
        }
        catch(MyException | MyException1 ex)
        {
            System.out.println(ex);
        }
        
    }
}
class MyException extends Exception{
    MyException(String msg){
		super(msg);
	}
}
class MyException1 extends Exception{
    MyException1(String msg){
		super(msg);
	}
}
class MyException2 extends MyException1{
    MyException2(String msg){
		super(msg);
	}
}