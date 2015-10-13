
package serializationlesson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



public class SerializationLesson {
    static List<User> users = new ArrayList<>();
    static List<User> desUsers = null;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        createList();
        File file = new File("E:\\\\serializeList.bin");
        FileOutputStream foStr = new FileOutputStream(file);
		try (ObjectOutputStream ooStrm = new ObjectOutputStream(foStr)) {
			ooStrm.writeObject(users);
			ooStrm.flush();
		}
        FileInputStream fiStr = new FileInputStream(file);
                try(ObjectInputStream oiStrm = new ObjectInputStream(fiStr)){
                   desUsers = (ArrayList)oiStrm.readObject();
                }
               
                for(User u : desUsers){
                    if(u.address == null)
                    {
                        System.out.println("null");
                        continue;
                    }
                    System.out.println(u.name + " "+u.age+" "+u.address.getStreet()+" "+u.address.getNumber()+ " " + u.address.getApartment());
                }
    }
    public static void createList(){
        users.add(new User("Vasya" , 25 , new Address("street1" , 62 , 18)));
        users.add(new User("Petya" , 20 , new Address("street2" , 41 , 27)));
        users.add(new User("Stepan" , 31 , new Address("street3" , 11 , 1)));
        users.add(new User("Valera" , 24 , new Address("street4" , 22 , 12)));
        users.add(new User("Oleg" , 25 , new Address("street5" , 33 , 15)));
    }
}
