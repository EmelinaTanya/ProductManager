package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookTest {
    private Book book = new Book(3, "Краткая история времени", 595, "Хокинг");

    @Test
    void  shouldMatchByAuthor() {
        String authorBook = "Хокинг";

        assertTrue(book.matches(authorBook));
    }

    @Test
    void  shouldMatchNotExistingByAuthor() {
        String authorBook = "Булгаков";

        assertFalse(book.matches(authorBook));
    }

    @Test
    void  shouldMatchByName() {
        String authorBook = "Краткая история времени";

        assertTrue(book.matches(authorBook));
    }

    @Test
    void  shouldMatchNotExistingByName() {
        String authorBook = "Мастер и Маргарита";

        assertFalse(book.matches(authorBook));
    }

}