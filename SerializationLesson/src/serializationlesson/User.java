
package serializationlesson;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;




public class User implements Serializable{
    String name;
    int age;
    transient Address address;
    
    public User(String name ,int age , Address address){
            this.name = name;
            this.age = age;
            this.address = address;
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException{
        out.defaultWriteObject();
        out.writeObject(name);
        out.writeInt(age);
        out.writeObject(address.getStreet());
        out.writeInt(address.getNumber());
        out.writeInt(address.getApartment());
        System.out.println("serialized");
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
       in.defaultReadObject();
       name = (String)in.readObject();
       age = in.readInt();
       address = new Address();
       address.setStreet((String)in.readObject());
       address.setNumber(in.readInt());
       address.setApartment(in.readInt());
        System.out.println("deserialized");
    }
}
