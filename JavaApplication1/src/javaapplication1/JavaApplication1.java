
package javaapplication1;
import base.oop.User;
import base.oop.Users;
import hello1.newpackage.hello2;
/**
 *
 * @author Serhiy
 */
public class JavaApplication1 {

   
    public static void main(String[] args) {
       System.out.println("Hello World!");
       hello2 hello = new hello2();
       hello.test();
       hello2.stat();
       testUsers();
    }
    public static void testUsers(){
        Users users = new Users();
        users.add(new User("vasya",25));
        User[] usersArr = new User[]{new User("kolya",20),new User("petya",40)};
        users.add(usersArr);
        users.add(new User("stepan",21),new User("jonh",30));
        System.out.println(users.info());
    }
}
