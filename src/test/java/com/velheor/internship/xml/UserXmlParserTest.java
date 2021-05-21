package com.velheor.internship.xml;

import com.velheor.internship.BasePersistenceTest;
import com.velheor.internship.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.velheor.internship.utils.TestUtils.EXPECTED_ALL_USERS;
import static com.velheor.internship.utils.TestUtils.USER_IGNORE;
import static org.assertj.core.api.Assertions.assertThat;

class UserXmlParserTest extends BasePersistenceTest {

    @Autowired
    private UserXmlParser userXmlParser;

    @Test
    void readFromXML() throws IOException, XMLStreamException, JAXBException {
        List<User> actual = userXmlParser.readUsersFromXML(Files.newInputStream(Paths.get("./src/test/resources/TestUsers.xml")));

        assertThat(actual).usingElementComparatorIgnoringFields(USER_IGNORE).isEqualTo(EXPECTED_ALL_USERS);
    }
}