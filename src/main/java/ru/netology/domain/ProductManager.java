package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;
    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }


    public Product[] searchBy(String name) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, name)) {
                // "добавляем в конец" массива result продукт product
                //System.arraycopy(product, 0, result, 0, result.length);

                int lastIndex = result.length - 1;
                result[lastIndex] = product;

            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
