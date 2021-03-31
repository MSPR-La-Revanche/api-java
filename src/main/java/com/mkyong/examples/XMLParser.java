package com.mkyong.examples;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLParser {

    public void parser(String path) {

        Database database = new Database();

        int id;
        String name, value;

        try {

            File file = new File(path);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("data");

            for(int itr = 0; itr < nodeList.getLength(); itr++) {

                Node node = nodeList.item(itr);

                if(node.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) node;
                    id = Integer.parseInt(eElement.getElementsByTagName("uniqueID").item(0).getTextContent());
                    name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    value = eElement.getElementsByTagName("value").item(0).getTextContent();

                    database.InsertIntoDatabase("datas", id, name, value); // insert into table 'datas'

                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
