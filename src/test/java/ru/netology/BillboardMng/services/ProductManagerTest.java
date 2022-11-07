package ru.netology.BillboardMng.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    BillboardItem item1 = new BillboardItem("Film_1");
    BillboardItem item2 = new BillboardItem("Film_2");
    BillboardItem item3 = new BillboardItem("Film_3");
    BillboardItem item4 = new BillboardItem("Film_4");
    BillboardItem item5 = new BillboardItem("Film_5");
    BillboardItem item6 = new BillboardItem("Film_6");
    BillboardItem item7 = new BillboardItem("Film_7");
    BillboardItem item8 = new BillboardItem("Film_8");
    BillboardItem item9 = new BillboardItem("Film_9");
    BillboardItem item10 = new BillboardItem("Film_10");
    BillboardItem item11 = new BillboardItem("Film_11");
    BillboardItem item12 = new BillboardItem("Film_12");

    @Test
    public void addFilmTest() {
        ProductManager repo = new ProductManager(); // добавление фильмов
        repo.addFilm(item1);
        repo.addFilm(item2);
        repo.addFilm(item3);

        BillboardItem[] expected = {item1, item2, item3};
        BillboardItem[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastDefTest() {
        ProductManager repo = new ProductManager(); //последние 10 по умолчанию
        repo.addFilm(item1);
        repo.addFilm(item2);
        repo.addFilm(item3);
        repo.addFilm(item4);
        repo.addFilm(item5);
        repo.addFilm(item6);
        repo.addFilm(item7);
        repo.addFilm(item8);
        repo.addFilm(item9);
        repo.addFilm(item10);
        repo.addFilm(item11);
        repo.addFilm(item12);

        BillboardItem[] expected = {item12, item11, item10, item9, item8, item7, item6, item5, item4, item3};
        BillboardItem[] actual = repo.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastVarTest() {
        ProductManager repo = new ProductManager(3);//последние 3
        repo.addFilm(item1);
        repo.addFilm(item2);
        repo.addFilm(item3);
        repo.addFilm(item4);
        repo.addFilm(item5);
        repo.addFilm(item6);
        repo.addFilm(item7);
        repo.addFilm(item8);
        repo.addFilm(item9);
        repo.addFilm(item10);
        repo.addFilm(item11);
        repo.addFilm(item12);

        BillboardItem[] expected = {item12, item11, item10};
        BillboardItem[] actual = repo.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastLessVarTest() {
        ProductManager repo = new ProductManager(7);//Просим показать больше чем есть
        repo.addFilm(item1);
        repo.addFilm(item2);
        repo.addFilm(item3);
        repo.addFilm(item4);
        repo.addFilm(item5);

        BillboardItem[] expected = {item5, item4, item3, item2, item1};
        BillboardItem[] actual = repo.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}
