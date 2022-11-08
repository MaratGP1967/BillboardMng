package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import ru.netology.domain.BillboardItem;

public class ProductManagerTest {
    @Test
    public void addFilmTest() {
        ProductRepository mass = new ProductRepository();
        ProductManager manager = new ProductManager(mass);

        BillboardItem item1 = new BillboardItem(1, "Film_1");
        BillboardItem item2 = new BillboardItem(2, "Film_2");
        BillboardItem item3 = new BillboardItem(3, "Film_3");

        manager.addFilm(item1);
        manager.addFilm(item2);
        manager.addFilm(item3);

        BillboardItem[] expected = {item1, item2, item3};
        BillboardItem[] actual = manager.allFilm();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void findLastDefTest() {  //последние 10 по умолчанию
        ProductRepository mass = Mockito.mock(ProductRepository.class);
        ProductManager manager = new ProductManager(mass);

        BillboardItem item1 = new BillboardItem(1, "Film_1");
        BillboardItem item2 = new BillboardItem(2, "Film_2");
        BillboardItem item3 = new BillboardItem(3, "Film_3");
        BillboardItem item4 = new BillboardItem(4, "Film_4");
        BillboardItem item5 = new BillboardItem(5, "Film_5");
        BillboardItem item6 = new BillboardItem(6, "Film_6");
        BillboardItem item7 = new BillboardItem(7, "Film_7");
        BillboardItem item8 = new BillboardItem(8, "Film_8");
        BillboardItem item9 = new BillboardItem(9, "Film_9");
        BillboardItem item10 = new BillboardItem(10, "Film_10");
        BillboardItem item11 = new BillboardItem(11, "Film_11");
        BillboardItem item12 = new BillboardItem(12, "Film_12");

        BillboardItem[] items = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12};
        doReturn(items).when(mass).findAll();

        BillboardItem[] expected = {item12, item11, item10,item9,item8,item7,item6,item5,item4,item3};
        BillboardItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastVarTest() { //последние 2
        ProductRepository mass = Mockito.mock(ProductRepository.class);
        ProductManager manager = new ProductManager(mass,2);

        BillboardItem item1 = new BillboardItem(1, "Film_1");
        BillboardItem item2 = new BillboardItem(2, "Film_2");
        BillboardItem item3 = new BillboardItem(3, "Film_3");
        BillboardItem item4 = new BillboardItem(4, "Film_4");
        BillboardItem item5 = new BillboardItem(5, "Film_5");
        BillboardItem item6 = new BillboardItem(6, "Film_6");
        BillboardItem item7 = new BillboardItem(7, "Film_7");
        BillboardItem item8 = new BillboardItem(8, "Film_8");
        BillboardItem item9 = new BillboardItem(9, "Film_9");
        BillboardItem item10 = new BillboardItem(10, "Film_10");
        BillboardItem item11 = new BillboardItem(11, "Film_11");
        BillboardItem item12 = new BillboardItem(12, "Film_12");

        BillboardItem[] items = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12};
        doReturn(items).when(mass).findAll();

        BillboardItem[] expected = {item12, item11};
        BillboardItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastLessVarTest() { //запрос колличества превышает длину массива
        ProductRepository mass = Mockito.mock(ProductRepository.class);
        ProductManager manager = new ProductManager(mass,5);

        BillboardItem item1 = new BillboardItem(1, "Film_1");
        BillboardItem item2 = new BillboardItem(2, "Film_2");
        BillboardItem item3 = new BillboardItem(3, "Film_3");

        BillboardItem[] items = {item1, item2, item3};
        doReturn(items).when(mass).findAll();

        BillboardItem[] expected = {item3, item2,item1};
        BillboardItem[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
