package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SmartphoneTest {
    private Product smartphone = new Smartphone(2, "Galaxy A10", 7980, "Samsung");

    @Test
    void shouldMatchByName() {
        String namePhone = "Galaxy A10";

        assertTrue(smartphone.matches(namePhone));
    }

    @Test
    void shouldMatchByCreator() {
        String producerPhone = "Samsung";

        assertTrue(smartphone.matches(producerPhone));
    }

    @Test
    void shouldMatchNotExistingByCreator() {
        String producerPhone = "Apple";

        assertFalse(smartphone.matches(producerPhone));
    }

    @Test
    void shouldMatchNotExistingByName() {
        String namePhone = "IPhone";

        assertFalse(smartphone.matches(namePhone));
    }

}