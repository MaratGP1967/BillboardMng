package ru.netology.repository;

import ru.netology.domain.BillboardItem;

public class ProductRepository {

    private BillboardItem[] items = new BillboardItem[0];

    public BillboardItem[] findAll() {
        return items;
    }

    public void save(BillboardItem item) {
        BillboardItem[] tmp = new BillboardItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public BillboardItem findById(int id) {
        for (BillboardItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        BillboardItem[] tmp = new BillboardItem[items.length - 1];
        int copyToIndex = 0;
        for (BillboardItem item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public void removeAll() {
        items = new BillboardItem[0];
    }

}
