
package lesson2syntax;

import java.util.Arrays;


public class TestArrays {
    int[] arr = new int[32];
    //new int {1,2,3};
    int[][] arr2d = new int[10][10];
    //new int {{1,2},{3,4}};
    public static void init(){
        int[] nums = new int[]{1,2,3,4,5};
        
        Double[] values = new Double[5];
        values[0] = 1.0;
        
        String[] names;
        names = new String[]{"Vasya" , "Petya" , "Stepan"};
        
        Integer[][] m = new Integer[8][8];
    } 
    
    public static void arraysMethods(){
        int[] x = new int[]{1,2,3,4,5};
        
        int[] y = new int[x.length];
        System.arraycopy(x, 0, y, 0, x.length); 
        
        for(int num: y){
            System.out.println(num);
        }
        
        int[] z = Arrays.copyOf(x, x.length);
        
        System.out.println(Arrays.toString(z));
        String[] words = new String[5];
        Arrays.fill(words, "qwerty");
        System.out.println(Arrays.toString(words));
        words = new String[]{"d","a","c","f","z","i"};
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
        
        int[][] m = new int[][]{{1,2,3},{3,4,5},{6,7,8}};
        System.out.println(Arrays.deepToString(m));
    } 
    
}
