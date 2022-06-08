package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    Product product1 = new Book(1, "Java", 10, "Shevchenko");
    Product product2 = new Smartphone(2, "Java", 10, "China");
    Product product3 = new Smartphone(3, "Java", 10, "China");

    @Test
    public void shouldSaveProduct() {
        repository.save(product1);
        repository.save(product2);

        Product[] expected = new Product[]{product1, product2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        repository.save(product1);
        repository.save(product2);

        Product[] expected = {product1, product2};
        Product[] actual = repository.findAll();
        // System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdTwoProducts() {
        repository.save(product1);
        repository.save(product2);

        repository.removeById(2);

        Product[] expected = {product1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNoProducts() {
        repository.removeById(2);

        Product[] expected = {};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdOneProduct() {
        repository.save(product2);

        repository.removeById(2);

        Product[] expected = {};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}

