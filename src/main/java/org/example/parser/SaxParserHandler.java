package org.example.parser;

import org.example.consts.Consts;
import org.example.model.Author;
import org.example.model.Line;
import org.example.model.Sonnet;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


public class SaxParserHandler extends DefaultHandler {
    private String currentTagName;
    private Sonnet sonnet = new Sonnet();
    private Author author = new Author();
    private List<Line> lineList = new ArrayList<>();
    private boolean isAuthor = false;
    private boolean isLines = false;
    public Sonnet getSonnet() {
        return sonnet;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTagName = qName;
        if (currentTagName.equals(Consts.TAG_AUTHOR)) {
            isAuthor = true;
        }
        if(currentTagName.equals(Consts.TAG_LINES)){
            isLines = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentTagName == null) return;
        if (currentTagName.equals(Consts.TAG_AUTHOR)) {
            isAuthor = false;
        }
        if(currentTagName.equals(Consts.TAG_LINES)){
            isLines = false;
        }
        currentTagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentTagName == null) return;

        String textContent = new String(ch, start, length);
        if (currentTagName.equals(Consts.TAG_TITLE)) {
            sonnet.setTitle(textContent);
        }
        if (isAuthor) {
            if (currentTagName.equals(Consts.TAG_FIRSTNAME)) {
                author.setFirstName(textContent);
            } else if (currentTagName.equals(Consts.TAG_LASTNAME)) {
                author.setLastName(textContent);
            } else if (currentTagName.equals(Consts.TAG_NATIONALITY)) {
                author.setNationality(textContent);
            } else if (currentTagName.equals(Consts.TAG_YEAR_OF_BIRTH)) {
                author.setDateOfBirth(textContent);
            } else if (currentTagName.equals(Consts.TAG_YEAR_OF_DEATH)) {
                author.setDateOfDeath(textContent);
            }
            sonnet.setAuthor(author);
        }
        if(isLines &&  currentTagName.equals("line")){
            lineList.add(new Line(textContent));
        }
        sonnet.setLines(lineList);
    }
}
