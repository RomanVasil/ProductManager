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

        Product product3 = new Product(3, "Java1", 10);
        Product product4 = new Product(4, "Java", 10);


        rep.add(product3);
        rep.add(product4);

        rep.searchBy("Java");

//        Product[] expected = new Product[]{product3};
//        Product[] actual = rep.searchBy("Java");
//        assertArrayEquals(expected, actual);
    }

}