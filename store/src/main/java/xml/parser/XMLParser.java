package xml.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class XMLParser {
    public static Map<String, String> xmlHandler(String s) {
        Map<String, String> configMap = new LinkedHashMap<String, String>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        Document doc = null;
        try {
            File inputFile = new File(s);
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);

        } catch (
                ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (
                SAXException ex) {
            ex.printStackTrace();
        } catch (
                IOException ioe) {
            ioe.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("sort");
        Node sortTag = nList.item(0);
        NodeList childNodes = sortTag.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            System.out.println("Current Element:" + node.getNodeName());
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                String tagName = eElement.getTagName();
                String textContent = eElement.getTextContent();
                System.out.println("Name:" + tagName + "Tag" + textContent);
                configMap.put(tagName, textContent);
            }
        }
    return configMap;
    }
}