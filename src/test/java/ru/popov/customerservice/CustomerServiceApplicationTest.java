package ru.popov.customerservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import ru.popov.customerservice.converters.SexConverter;
import ru.popov.customerservice.support.Sex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class CustomerServiceApplicationTest {
    @Autowired
    ApplicationContext context;

    @Test
    void contextLoads() {}

    @Test
    void isSexConverterWorksFine() {

        SexConverter converter = new SexConverter();

        assertEquals(converter.convertToDatabaseColumn(Sex.FEMALE), "female");
        assertEquals(converter.convertToDatabaseColumn(Sex.MALE), "male");
    }

    @Test
    void isThereIsNothingToTestHere() {

        boolean somethingToTest = false;
        assertFalse(somethingToTest);
    }

}