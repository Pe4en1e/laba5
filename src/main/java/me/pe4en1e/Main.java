package me.pe4en1e;

import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args) {
        DatabaseWorker databaseWorker = new DatabaseWorker();
//        databaseWorker.createTableShop();
//        databaseWorker.createTableProduct();
//        databaseWorker.createTableWarehouse();

            databaseWorker.addToShop("shopname", "123");
    }
}