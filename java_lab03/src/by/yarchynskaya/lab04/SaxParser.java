package by.yarchynskaya.lab04;


import by.yarchynskaya.team.Worker;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser extends DefaultHandler {

    Worker worker = new Worker();
    String thisElement = "";

    public Worker getResult(){ return worker; };
    @Override
    public void startDocument() throws SAXException {
        System.out.println("----> Start parse XML...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("----> Stop parse XML...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(thisElement.equals("surname")){
            worker.surname=new String(ch,start,length);
        }else if(thisElement.equals("name")){
            worker.name=new String(ch,start,length);
        }else if(thisElement.equals("age")){
            worker.age=new Integer(new String(ch, start, length));
        }else if(thisElement.equals("salary")){
            worker.salary=new Integer(new String(ch, start, length));
        }else if(thisElement.equals("experience")){
            worker.experience=new Integer(new String(ch, start, length));
        }
    }
}
