package com.velheor.internship.xml;

import com.velheor.internship.utils.RandomDataInPojo;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

class PureJaxbParserTest {

    private final PureJaxbParser pureJaxbParser;

    PureJaxbParserTest() {
        pureJaxbParser = new PureJaxbParser();
    }

    @Test
    void readLargeFileWithJaxb() throws Exception {
        pureJaxbParser.readLargeFileWithJaxb("./src/test/resources/TestUsers.xml");
    }

    @Test
    void randomizedData() throws JAXBException, FileNotFoundException {
        RandomDataInPojo randomDataInPojo = new RandomDataInPojo();
        randomDataInPojo.creatingTestData();
    }
}