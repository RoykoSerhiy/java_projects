
package junittest;


public class Junittest {

    
    public static void main(String[] args) {
        Band b = new Band();
        for(int i = 0;i< 10;++i)
        {
            b.addUser(new User("Vasya" + i , 22+ i));
        }
    }
    
}
