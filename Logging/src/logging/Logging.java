
 
package logging;


public class Logging {

    
    public static void main(String[] args) {
        TestLogger tl = new TestLogger();
        for(int i = 0;i < 50;i+=5)
        {
            tl.procces(i);
        }
    }
    
}
