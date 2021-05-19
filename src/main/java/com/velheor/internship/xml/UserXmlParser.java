package com.velheor.internship.xml;

import com.velheor.internship.models.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class UserXmlParser {

    public List<User> readFromXML(InputStream is) throws XMLStreamException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLStreamReader reader = null;
        try {
            reader = inputFactory.createXMLStreamReader(is);
            return readDocument(reader);
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    private List<User> readDocument(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int eventType = reader.next();
            switch (eventType) {
                case XMLStreamReader.START_ELEMENT:
                    String elementName = reader.getLocalName();
                    if (elementName.equals("Users"))
                        return readUsers(reader);
                    break;
                case XMLStreamReader.END_ELEMENT:
                    break;
            }
        }
        throw new XMLStreamException("Premature end of file");
    }


    private List<User> readUsers(XMLStreamReader reader) throws XMLStreamException {
        List<User> users = new ArrayList<>();

        while (reader.hasNext()) {
            int eventType = reader.next();
            switch (eventType) {
                case XMLStreamReader.START_ELEMENT:
                    String elementName = reader.getLocalName();
                    if (elementName.equals("User"))
                        users.add(readUser(reader));
                    break;
                case XMLStreamReader.END_ELEMENT:
                    return users;
            }
        }
        throw new XMLStreamException("Premature end of file");
    }


    @SneakyThrows
    public User readUser(XMLStreamReader reader) {
        User user = new User();
        while (reader.hasNext()) {
            int eventType = reader.next();
            switch (eventType) {
                case XMLStreamReader.START_ELEMENT:
                    String elementName = reader.getLocalName();
                    switch (elementName) {
                        case "id":
                            user.setId(readUUID(reader));
                            break;
                        case "first_name":
                            user.setFirstName(readCharacters(reader));
                            break;
                        case "last_name":
                            user.setLastName(readCharacters(reader));
                            break;
                        case "email":
                            user.setEmail(readCharacters(reader));
                            break;
                        case "phone_number":
                            user.setPhoneNumber(readCharacters(reader));
                            break;
                        case "password":
                            user.setPassword(readCharacters(reader));
                            break;
                        case "active":
                            user.setActive(readActive(reader));
                            break;
                    }
                    break;
                case XMLStreamReader.END_ELEMENT:
                    return user;
            }
        }
        throw new XMLStreamException("Premature end of file");
    }

    private UUID readUUID(XMLStreamReader reader) throws XMLStreamException {
        return UUID.fromString(readCharacters(reader));
    }

    private String readCharacters(XMLStreamReader reader) throws XMLStreamException {
        StringBuilder result = new StringBuilder();
        while (reader.hasNext()) {
            int eventType = reader.next();
            switch (eventType) {
                case XMLStreamReader.CHARACTERS:
                case XMLStreamReader.CDATA:
                    result.append(reader.getText());
                    break;
                case XMLStreamReader.END_ELEMENT:
                    return result.toString();
            }
        }
        throw new XMLStreamException("Premature end of file");
    }

    private boolean readActive(XMLStreamReader reader) throws XMLStreamException {
        String characters = readCharacters(reader);
        try {
            return 1 == Integer.parseInt(characters);
        } catch (NumberFormatException e) {
            throw new XMLStreamException("Invalid integer " + characters);
        }
    }
}
