package org.example.parser;

import org.example.model.Sonnet;
import org.xml.sax.SAXException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxParser {

    public Sonnet parse() {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParserHandler handler = new SaxParserHandler();
        SAXParser parser = null;

        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            System.out.println("Sax parser error " + e);
        }
        File file = new File("resource.xml");

        try {
            parser.parse(file, handler);
        } catch (SAXException e) {
            System.out.println("Error.");
        } catch (IOException e) {
            System.out.println("Error!");
        }

        return handler.getSonnet();
    }
}
