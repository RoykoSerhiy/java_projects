
package threadlesson;

import java.util.concurrent.Semaphore;


public class SomeClass extends Thread {
    Semaphore s;
    String name;
    public SomeClass(String n , Semaphore s){
        this.name = n;
        this.s = s;
    }
    
    @Override
    public void run(){
        runWithSemaphore();
    }
    
    public void runWithSemaphore(){
       
        try{
            s.acquire();
            for(int i = 0;i<5;++i){
                System.out.printf("%s : %d\n" , name , i);
                Thread.sleep(100);
            }
        }
        catch(InterruptedException ex){
            
        }
        finally{
            s.release();
        }
    }
}
