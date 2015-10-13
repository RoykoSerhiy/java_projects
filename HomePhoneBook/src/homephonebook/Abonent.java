
package homephonebook;

import java.io.Serializable;


public class Abonent implements Serializable {
    public String name;
    public String surname;
    public String phone;
    
    public Abonent(String name ,String surname, String phone)
    {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }
}
