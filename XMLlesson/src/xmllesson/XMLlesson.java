/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmllesson;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Serhiy
 */
public class XMLlesson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        String fileName = "myXml.xml";
        DocumentBuilderFactory docfact = DocumentBuilderFactory.newInstance();
        DocumentBuilder docbuilder = docfact.newDocumentBuilder();
        Document doc = docbuilder.parse(fileName);
        
        XPath xpath = XPathFactory.newInstance().newXPath();
        
        String itemPath = "/root/unit";
        NodeList nodes = (NodeList) xpath.evaluate(itemPath,doc.getDocumentElement(),XPathConstants.NODESET);
        for(int i=0;i<nodes.getLength();++i){
            Element elem = (Element) nodes.item(i);
            System.out.println(elem.getAttribute("id") + ": " + elem.getTextContent());
        }
        
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLlesson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XMLlesson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLlesson.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(XMLlesson.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
