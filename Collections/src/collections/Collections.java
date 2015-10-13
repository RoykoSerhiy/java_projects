
package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Collections {

   
    public static void main(String[] args) {
        //arrlist();
        //map();
    }
    public static void arrlist(){
        List<Integer> arrlist = new ArrayList<>();
      for(int i = 0 ; i<=6; ++i)
      {
          arrlist.add(i);
      }
      for(Iterator<Integer> it = arrlist.iterator(); it.hasNext();)
      {
            Integer x = it.next();
            if(x % 2 == 0)
            {
                it.remove();
            }
      }
      for(Integer i: arrlist)
      {
          
          System.out.println(i.toString());
      }
    }
    public static void map(){
        Map<String , Double> goods = new HashMap<>(); 
        goods.put("lexus",100000.50);
        goods.put("bently",200000.10);
        goods.put("jaguar",120000.50);
        goods.put("ford",50000.90);
        
        for(String key: goods.keySet())
        {
            System.out.println(key + "->" +goods.get(key).toString());
        }
    }
    public static void queue(){
        
    }
}
