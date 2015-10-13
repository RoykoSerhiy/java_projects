
package lesson2syntax;


public class StringActions {
    public static void test(){
        StringBuilder s = new StringBuilder("User:");
        s.append("Vasya");
        s.append(" ");
        s.append("Pupkin");
        s.append(". 1980-10-25");
        System.out.println(s.toString());
    }
    
    public static void speedTest(){
        String a = "";
        long t1 = System.currentTimeMillis();
        for(int i = 0;i<10000;++i)
        {
            a += Integer.toString(i);
            
        }
        long t2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        long t3 = System.currentTimeMillis();
        for(int i = 0;i<10000;++i)
        {
           sb.append(Integer.toString(i));
            
        }
        long t4 = System.currentTimeMillis();
        
        System.out.println("String score: " + Long.toString(t2 - t1));
        System.out.println("String builder score: " + Long.toString(t4 - t3));
    }

}
