package ru.netology.repository;

import ru.netology.domain.BillboardItem;

public class ProductManager {
    private ProductRepository repo;
    private int lastNumberOfFilms = 10;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public ProductManager(ProductRepository repo, int lastNumberOfFilms) {
        this.repo = repo;
        this.lastNumberOfFilms = lastNumberOfFilms;
    }

    public void addFilm(BillboardItem item) {
        repo.save(item);
    }

    public BillboardItem[] allFilm() {
        return repo.findAll();
    }

    public BillboardItem[] findLast() {
        BillboardItem[] actual = repo.findAll();
        int count;
        if (actual.length > lastNumberOfFilms) {
            count = lastNumberOfFilms;
        } else {
            count = actual.length;
        }
        BillboardItem[] reversedLast = new BillboardItem[count];
        for (int i = 0; i < reversedLast.length; i++) {
            reversedLast[i] = actual[actual.length - 1 - i];
        }
        return reversedLast;
    }
}
