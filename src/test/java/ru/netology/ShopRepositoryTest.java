package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(11, "хлеб", 48);
    Product product2 = new Product(23, "батон", 52);
    Product product3 = new Product(35, "молоко", 89);


    @Test
    public void shouldIdFound() throws Exception {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(35);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldIdNotFound() throws Exception {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });
    }

    @Test
    public void shouldIdAdd() throws Exception {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldIdNotAdd() throws Exception {
        Product product4 = new Product(35, "кефир", 62);
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(AlreadyExistException.class, () -> {
            repo.add(product4);
        });
    }
}
