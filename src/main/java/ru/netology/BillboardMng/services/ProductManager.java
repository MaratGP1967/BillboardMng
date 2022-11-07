package ru.netology.BillboardMng.services;

public class ProductManager {
    private int lastNumberOfFilms = 10;

    public ProductManager() {
    }

    public ProductManager(int lastNumberOfFilms) {
        this.lastNumberOfFilms = lastNumberOfFilms;
    }

    private BillboardItem[] items = new BillboardItem[0];

    public void addFilm(BillboardItem item) {
        BillboardItem[] tmp = new BillboardItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public BillboardItem[] findAll() {
        return items;
    }

    public BillboardItem[] findLast() {
        int count;
        if (items.length > lastNumberOfFilms) {
            count = lastNumberOfFilms;
        } else {
            count = items.length;
        }
        BillboardItem[] reversedLast = new BillboardItem[count];
        for (int i = 0; i < reversedLast.length; i++) {
            reversedLast[i] = items[items.length - 1 - i];
        }
        //items = reversedLast;
        return reversedLast;
    }
}
