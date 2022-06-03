package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book product1 = new Book();
    private Smartphone product2 = new Smartphone();



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

//        Product product1 = new Product(1, "Java", 10);
//        Product product2 = new Product(2, "Java", 10);

        repository.save(product1);
        repository.save(product2);

        Product[] expected = {product1, product2};
        Product[] actual = repository.findAll();
        // System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

    @Test

    public void  shouldRemoveById(){

        Product product1 = new Product(1, "Java", 10);
        Product product2 = new Product(2, "Java", 10);

        repository.save(product1);
        repository.save(product2);

        repository.removeById(2);

        Product[] expected = {product1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }
}

