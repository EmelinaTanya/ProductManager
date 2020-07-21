package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductTest {
    private Product product = new Book(1, "Краткие ответы на большие вопросы", 550, "Хокинг");
    @Test
    void shouldMatchByName() {
        String name = "Краткие ответы на большие вопросы";

        assertTrue(product.matches(name));
    }

    @Test
    void shouldMatchNotExistingByName(){
        String name = "Три мушкетера";

        assertFalse(product.matches(name));
    }
}