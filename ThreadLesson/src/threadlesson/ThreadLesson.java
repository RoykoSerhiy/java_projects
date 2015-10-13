
package threadlesson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ThreadLesson {

   
    public static void main(String[] args) throws InterruptedException {
        
       //MarkedThread t1 = new MarkedThread("a");
      // MarkedThread t2 = new MarkedThread("-");
      // t1.start();
      // t2.start();
        //sync();
        Semaphore semaphore = new Semaphore(3);
        List<SomeClass> list = new ArrayList<>();
        for(int i = 0;i<10;++i){
            list.add(new SomeClass("name" + i, semaphore));
        }
        
        for(SomeClass s : list){
            s.start();
        }
    }
    public static void sync(){
        class SyncTest implements Runnable{
            private volatile int number;
            @Override
            public void run() {
                synchronized(this){
               for(int i = 0;i<20;++i){
                   System.out.printf("%s (%d)\n" , hashCode() , i);
               }
            }
            }
            
        }
        Thread t1 = new Thread(new SyncTest());
        Thread t2 = new Thread(new SyncTest());
        t1.start();
        t2.start();
    }
    
}
//class SomeThread extends Thread{
//    @Override
//    public void run(){
 //       int i = 10;
 //       while(--i > 0){
 //           System.out.println("i = " + i);
 //           try{
   //             Thread.sleep(100);
  //          }catch(InterruptedException ex){
                
  //          }
  //  }
  //  }
//}
class MarkedThread extends Thread{
    String marker;
    public MarkedThread(String marker){
        this.marker = marker;
    }
    @Override
    public void run(){
        Todo t = new Todo();
        t.todo(marker);
    }
    
} 
class Todo{
    synchronized void todo(String marker){ 
        int i = 50;
        while(--i > 0){
            //System.out.printf("%s i = %d\n",marker,i);
            System.out.printf("%s",marker);
            //try{
           //     Thread.sleep(10);
           // }catch(InterruptedException ex){
                
           // }
        }
    }
}
