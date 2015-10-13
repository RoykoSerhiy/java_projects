
package homephonebook;


import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class HomePhoneBook {

    
    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(
                    PhoneBook.class.getResourceAsStream("/logging.properties"));
        } catch (IOException ex) {
            Logger.getLogger(HomePhoneBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(HomePhoneBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        PhoneBook pb = new PhoneBook();
        menu(pb);
    }
    public static void menu(PhoneBook phonebook){
        PhoneBook pb = phonebook;
        boolean exit = false;
        Scanner inputMenu= new Scanner(System.in);
        Scanner input= new Scanner(System.in);
        int c = -1;
       
    try
      {
           
       pb.readFromFile();
       while(!exit)
       {
        System.out.println("Menu: 1.Add Abonent , 2.Remove Abonent , "
                + "3.Search Abonent , 4.Redact Abonent , 5.Show all book ,"
                + " 6.Clear all book,7.save,8.parse to xml ,9.reag from XML, 0.exit");
        c = inputMenu.nextInt();
        switch(c){
            case 1:
            {
                System.out.println("Enter name");
                String name = input.nextLine();
                System.out.println("Enter surname");
                String surname = input.nextLine();
                System.out.println("Enter phone");
                String phone = input.nextLine();
                pb.addAbonent(name, surname, phone);
                
                break;
            }
            case 2:
            {
                System.out.println("Enter name");
                String name = input.nextLine();
                pb.removeAbonent(name);
                
                break;
            }
            case 3: 
            {
                System.out.println("Enter name");
                String name = input.nextLine();
                pb.searchAbonent(name);
               
                break;
            }
            case 4:
            {
                System.out.println("Enter name");
                String name = input.nextLine();
                
                pb.redactAbonent(name);
                
                break;
            }
            case 5:
            {
               pb.showBook();
                
                break;
            }
            case 6:
            {
                pb.clear();
                
                break;
            }
            case 7:
            {
                pb.saveToFile();
                break;
            }
            case 8:
            {
                pb.parseToXML();
                break;
            }
            case 9:
            {
                pb.readFromXML();
                break;
            }
            case 0:
            {
                System.out.println("Save abonents: 1->yes, 2->no");
                Scanner s = new Scanner(System.in);
                int m = s.nextInt();
               
                switch(m){
                    case 1:
                    {
                        pb.saveToFile();
                    }
                    case 2:
                    {
                        exit = true;
                        break;
                    }
                    default:
                    {
                        System.out.println("you entered wrong data but list save into file");
                        pb.saveToFile();
                        exit = true;
                        
                    }
                 }
                break;
            }
            default:
            {
                
                throw new WrongInput();
            }
        }
       }
    }
    catch(WrongInput ex)
    {
            System.out.println(ex.getMessage());
            menu(phonebook);
    }
    catch(Exception ex){
          ex.printStackTrace();
         // menu(phonebook);       
    }
        
    }
    
}
class WrongInput extends Exception{
    WrongInput()
    { 
        super("Wrong number input.Input only integer type");
    }
}