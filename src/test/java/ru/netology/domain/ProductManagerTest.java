package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductManager rep = new ProductManager(new ProductRepository());

    @Test
    public void shouldSearchBy() {
        Product product1 = new Book(3, "JaIva", 10, "Shevchenko");
        Product product2 = new Smartphone(4, "Java", 10, "China");

        rep.add(product1);
        rep.add(product2);

        String name = "Java";

        Product[] expected = new Product[]{product2};
        Product[] actual = rep.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNoName() {

        Product product3 = new Book(5, "Javan", 10, "Shevchenko");
        Product product4 = new Smartphone(6, "Java", 10, "China");

        rep.add(product3);
        rep.add(product4);

        String name = "Lost";

        Product[] expected = new Product[]{};
        Product[] actual = rep.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNoProduct() {

        String name = "Lost";

        Product[] expected = new Product[]{};
        Product[] actual = rep.searchBy(name);
        assertArrayEquals(expected, actual);
    }
}