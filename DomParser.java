package main.java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParserExample {
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
	    
		//if(args.length != 1)
			//throw new RuntimeException("The name of the XML file is required!");
		

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		//File employeeFile = new File("Employees.xml");
		File SMSFile = new File("smsCorpusAnonymized-1.1.xml"); 
		
		//Document document = builder.parse(employeeFile);
		Document document = builder.parse(SMSFile); 
		

		//List<Employee> employees = new ArrayList<Employee>();
		List<SMS> sms = new ArrayList<SMS>(); 

		
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) node;
				     
				
				String id = elem.getAttribute("id"); 
				String text =elem.getElementsByTagName("text").item(0).getChildNodes().item(0).getNodeValue(); 
				String country = elem.getElementsByTagName("source").item(0).getAttributes().item(0).getNodeValue(); 
				String srcID = elem.getElementsByTagName("srcID").item(0).getChildNodes().item(0).getNodeValue(); 
				String collector = elem.getElementsByTagName("collectionMethod").item(0).getAttributes().item(0).getNodeValue();
				String year = elem.getElementsByTagName("collectionMethod").item(0).getAttributes().getNamedItem("year").getNodeValue(); 
				
				

				sms.add(new SMS (id,text,  country,  srcID,  collector,  year)); 
				 
			}
		}
		// Print all employees.
		for (SMS text : sms)
			System.out.println(text.toString());
	}
}
