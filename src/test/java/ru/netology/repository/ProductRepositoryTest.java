package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.BillboardItem;

public class ProductRepositoryTest {
    BillboardItem item1 = new BillboardItem(1, "Film_1");
    BillboardItem item2 = new BillboardItem(2, "Film_2");
    BillboardItem item3 = new BillboardItem(3, "Film_3");

    @Test
    public void saveTest() {
        ProductRepository mass = new ProductRepository();
        mass.save(item1);
        mass.save(item2);
        mass.save(item3);

        BillboardItem[] expected = {item1, item2, item3};
        BillboardItem[] actual = mass.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findByIdTest() {
        ProductRepository mass = new ProductRepository();
        mass.save(item1);
        mass.save(item2);
        mass.save(item3);

        BillboardItem expected = (item2);
        BillboardItem actual = mass.findById(2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findNotByIdTest() {
        ProductRepository mass = new ProductRepository();
        mass.save(item1);
        mass.save(item2);
        mass.save(item3);

        BillboardItem expected = (null);
        BillboardItem actual = mass.findById(5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeByIdTest() {
        ProductRepository mass = new ProductRepository();
        mass.save(item1);
        mass.save(item2);
        mass.save(item3);
        mass.removeById(2);

        BillboardItem[] expected = {item1, item3};
        BillboardItem[] actual = mass.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeAllTest() {
        ProductRepository mass = new ProductRepository();
        mass.save(item1);
        mass.save(item2);
        mass.save(item3);
        mass.removeAll();

        BillboardItem[] expected = {};
        BillboardItem[] actual = mass.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}
