package com.velheor.internship.xml;

import lombok.Getter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;


@Getter
public class StaxStreamProcessor<T> implements AutoCloseable {
    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();
    private final XMLStreamReader reader;
    private final JAXBContext context;
    private final Unmarshaller unmarshaller;
    private final Class<T> type;

    public StaxStreamProcessor(InputStream is, Class<T> type, String parent) throws XMLStreamException, JAXBException {
        reader = FACTORY.createXMLStreamReader(is);
        context = JAXBContext.newInstance(type);
        unmarshaller = context.createUnmarshaller();
        this.type = type;

        reader.nextTag();
        reader.require(XMLStreamConstants.START_ELEMENT, null, parent);
        reader.nextTag();
    }

    public boolean startElement() {
        return reader.getEventType() == XMLStreamConstants.START_ELEMENT;
    }

    public T getValue() throws JAXBException, XMLStreamException {
        T t = unmarshaller.unmarshal(reader, type).getValue();
        if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
            reader.next();
        }
        return t;
    }

    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (XMLStreamException e) { // empty
            }
        }
    }
}
