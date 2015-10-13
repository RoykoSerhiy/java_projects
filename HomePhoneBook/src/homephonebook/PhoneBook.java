
package homephonebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.nio.*;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

public class PhoneBook {
    private static final Logger logger = Logger.getLogger(PhoneBook.class.getName());
    public File file = new File("E:\\\\objects.bin");
    public String fileName = "Abonents.xml";
    public Map<String , Abonent> list = new HashMap<>();
    
    public void addAbonent(String name ,String surname, String phone)
    {
        if(name != null || phone != null || surname != null)
        {
            Abonent abonent = new Abonent(name ,surname, phone);
            this.list.put(abonent.name, abonent);
            System.out.println(this.list.size());
            logger.info("Abonent added");
        }
    }
    public void redactAbonent(String name)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new name , urname , phone");
        String newName = input.nextLine();
        String newSurname = input.nextLine();
        String newPhone = input.nextLine();
        Abonent a = this.list.get(name);
        this.list.remove(name);
        a.name = newName;
        a.surname = newSurname;
        a.phone = newPhone;
        this.list.put(a.name, a);
        System.out.println("Abonent "+a.name + " " + a.surname + "["+a.phone+"]");
        logger.info("Abonent redacted");
    }
    public void searchAbonent(String name)
    {
        Abonent a = this.list.get(name);
        if(a != null)
        {
            System.out.println("Abonent: " + a.name +" "+a.surname+ " ["+a.phone+"]");
        }
        else
        {
            System.out.println("No abonent with name " + name);
        }
    }
    public void removeAbonent(String name)
    {
        if(name != null)
        {
            this.list.remove(name);
            System.out.println("Abonent with name " + name + "removed");
            logger.info("Abonent removed");
        }
        else
        {
            System.out.println("Enter name!!!");
            logger.warning("name is null");
        }
    }
    public void showBook(){
        if(!this.list.isEmpty())
        {
            for(String key: this.list.keySet())
            {
                System.out.println("Abonent:"+ key + " "+this.list.get(key).surname  + " phone[" +this.list.get(key).phone+"]");
            }
        }
        else
        {
            System.out.println("Phone book is empty");
        }
        
    }
    public void clear(){
        this.list.clear();
        System.out.println("Cleared");
        logger.info("Book cleared");
    }
    public void saveToFile() throws FileNotFoundException, IOException{
        
        FileOutputStream fos = new FileOutputStream(file);
        try(ObjectOutputStream oos = new ObjectOutputStream(fos)){
            if(!list.isEmpty()){
                 oos.writeObject(list);
                 oos.flush();
                 oos.close();
                 System.out.println("Data saved in file");
                 logger.info("Book saved");
             }
            else
            {
                System.out.println("Empty list!!!");
                oos.flush();
                oos.close();
            }
        }
        
    }
    public void readFromFile() throws FileNotFoundException, IOException{
        FileInputStream fis = new FileInputStream(file);
        if(file.length() != 0)
        {
        try(ObjectInputStream oin = new ObjectInputStream(fis)){
            list.clear();//очищаємо список
            list = (HashMap<String , Abonent>)oin.readObject();
            oin.close();
            logger.info("Book readed");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PhoneBook.class.getName()).log(Level.SEVERE, null, ex);
            logger.warning("Error: " + ex.getMessage());
        }
        catch(EOFException ex){
            list = new HashMap<>();
                    
        }
        }
           
        
    }
    public void parseToXML(){
        try
        {
            System.out.println("parsing...");
        DocumentBuilderFactory docfact = DocumentBuilderFactory.newInstance();
	DocumentBuilder docbuilder = docfact.newDocumentBuilder();
	Document doc = docbuilder.newDocument();
	
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Result output = new StreamResult(new File(fileName));
        Source input = new DOMSource(doc);

        
	XPath xpath = XPathFactory.newInstance().newXPath();
        
        String itemsPath = "/root";
        Node node = (Node) xpath.evaluate(itemsPath, doc.getDocumentElement(), XPathConstants.NODE);
        for(String key :this.list.keySet())
        {
            Element abonentElem = doc.createElement("abonent");
                abonentElem.setAttribute("id", key);
                Element name = doc.createElement("name");
                name.setTextContent(this.list.get(key).name);
                abonentElem.appendChild(name);
                
                Element surname = doc.createElement("surname");
                surname.setTextContent(this.list.get(key).surname);
                abonentElem.appendChild(surname);
                
                Element phone = doc.createElement("phone");
                phone.setTextContent(this.list.get(key).phone);
                abonentElem.appendChild(phone);
                
                node.appendChild(abonentElem);
                
                
        }
        
            logger.info("Book parsed to xml");
            System.out.println("parsed");
           transformer.transform(input,output);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(PhoneBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(PhoneBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(PhoneBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(PhoneBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void readFromXML(){
        try{
            DocumentBuilderFactory docfact = DocumentBuilderFactory.newInstance();
            DocumentBuilder docbuilder = docfact.newDocumentBuilder();
            Document doc = docbuilder.parse(fileName);
			
            XPath xpath = XPathFactory.newInstance().newXPath();
            
            String itemPath = "/root/abonent";
            NodeList nodes = (NodeList) xpath.evaluate(itemPath,doc.getDocumentElement(),XPathConstants.NODESET);
            for(int i=0;i<nodes.getLength();++i){
               Element elem = (Element) nodes.item(i);
              
               System.out.println(elem.getElementsByTagName("name").item(0).getTextContent() + " " +
                                  elem.getElementsByTagName("surname").item(0).getTextContent() + "[" +
                                  elem.getElementsByTagName("phone").item(0).getTextContent() + "]"       
               );
         }
        }catch (ParserConfigurationException ex) {
            Logger.getLogger(PhoneBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(PhoneBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PhoneBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(PhoneBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
