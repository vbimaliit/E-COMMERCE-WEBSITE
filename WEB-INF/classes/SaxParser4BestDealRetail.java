import java.util.HashMap;
import java.util.Map;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser4BestDealRetail extends DefaultHandler {
	
	Laptop laptop;
	List<Laptop> laptops;
	HashMap<String,Laptop> prods =  new HashMap<String,Laptop> ();
	String laptopXMLFilename;
	String elementValueRead;
	String id;
	
    public SaxParser4BestDealRetail(String laptopXMLFilename) {
    this.laptopXMLFilename = laptopXMLFilename;
	System.out.println(laptopXMLFilename);
    laptops = new ArrayList<Laptop>();
    parseDocument();
  //  prettyPrint();
    }    
    private void parseDocument() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(laptopXMLFilename, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }


    @Override
    public void startElement(String str1, String str2, String elementName, Attributes attributes) throws SAXException {

        if (elementName.equalsIgnoreCase("laptop")) {
        	laptop = new Laptop();
			
        	laptop.setId(attributes.getValue("id"));
		    id = attributes.getValue("id");
        	laptop.setRetailer(attributes.getValue("retailer"));
        }

    }

    @Override
    public void endElement(String str1, String str2, String element) throws SAXException {
 
        if (element.equals("laptop")) {
			prods.put(id,laptop);
       //     laptops.add(laptop);
	    return;
        }
        if (element.equalsIgnoreCase("name")) {
            laptop.setName(elementValueRead);
	    return;
        }

        if (element.equalsIgnoreCase("condition")) {
            laptop.setCondition(elementValueRead);
	    return;
        }
        if(element.equalsIgnoreCase("price")){
        	laptop.setPrice(Integer.parseInt(elementValueRead));
	    return;
        }
        if(element.equalsIgnoreCase("producttype")){
			System.out.println(elementValueRead);
        	laptop.setProducttype(elementValueRead);
	    return;
        } 
    }

    @Override
    public void characters(char[] content, int begin, int end) throws SAXException {
        elementValueRead = new String(content, begin, end);
    }

  //  public static void main(String[] args) {
  //      new SaxParser4BestDealRetail("ProductCatalog.xml");

  //  }

}
