package com.jaya.handler;

import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author wangjianying
 * @Title: XmlReader
 * @Description: ${END}
 * @date 2019/3/3118:11
 */
public class XmlReader implements ContentHandler {

    private Properties properties;

    private String key = null;

    private String value = null;

    public XmlReader(Properties properties, InputStream inputStream) {
        this.properties = properties;
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(this);
            xmlReader.parse(new InputSource(inputStream));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setDocumentLocator(Locator locator) {

    }

    public void startDocument() throws SAXException {
        System.out.println("start document");
    }

    public void endDocument() throws SAXException {
        System.out.println("end document");
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        System.out.println(prefix);
    }

    public void endPrefixMapping(String prefix) throws SAXException {
        System.out.println(prefix);
    }

    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("property")) {
            this.key = atts.getValue("name");
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("property")) {
            properties.setProperty(this.key, this.value);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        value = new String(ch, start, length);
    }

    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    public void processingInstruction(String target, String data) throws SAXException {

    }

    public void skippedEntity(String name) throws SAXException {

    }
}
