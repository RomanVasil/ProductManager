package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductManager rep = new ProductManager(new ProductRepository());

    private Book product3 = new Book();
    private Smartphone product4 = new Smartphone();

    @Test
    public void shouldSearchBy() {

        Product product3 = new Product(3, "Javan", 10);
        Product product4 = new Product(4, "Java", 10);

        rep.add(product3);
        rep.add(product4);

        String name = "Java";

        Product[] expected = new Product[]{product4};
        Product[] actual = rep.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy0() {

        Product product5 = new Product(5, "Javan", 10);
        Product product6 = new Product(6, "Java", 10);

        rep.add(product5);
        rep.add(product6);

        String name = "Lost";

        Product[] expected = new Product[]{};
        Product[] actual = rep.searchBy(name);
        assertArrayEquals(expected, actual);
    }
}