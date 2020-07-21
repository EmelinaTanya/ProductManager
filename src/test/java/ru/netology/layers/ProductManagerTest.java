package ru.netology.layers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product book1 = new Book(1, "Краткие ответы на большие вопросы", 550, "Хокинг");
    private Product book2 = new Book(4, "Как стать лидером и выжить в кризис", 405, "Honor");
    private Product book3 = new Book(3, "Краткая история времени", 595, "Хокинг");
    private Product phone1 = new Smartphone(2, "Galaxy A10", 7980, "Samsung");
    private Product phone2 = new Smartphone(5, "8S", 5980, "Honor");

    @BeforeEach
    public void manageAdd() {
        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone2);
    }

    @Test
    public void shouldSearchByBook() {
        Product[] actual = manager.searchBy("Хокинг");
        Product[] expected = new Product[]{book1, book3};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByPhone() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{phone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByPhoneAndBook() {
        Product[] actual = manager.searchBy("Honor");
        Product[] expected = new Product[]{book2, phone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindExistingBookByName() {
        String nameBook = "Краткая история времени";
        Product[] expected = new Product[]{book3};
        Product[] actual = manager.searchBy(nameBook);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindExistingPhoneByName() {
        String namePhone = "8S";
        Product[] expected = new Product[]{phone2};
        Product[] actual = manager.searchBy(namePhone);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindExistingPhoneByCreator() {
        String creatorPhone = "Samsung";
        Product[] expected = new Product[]{phone1};
        Product[] actual = manager.searchBy(creatorPhone);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByWhenMissingProduct() {
        Product[] actual = manager.searchBy("нет такого продукта");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

}