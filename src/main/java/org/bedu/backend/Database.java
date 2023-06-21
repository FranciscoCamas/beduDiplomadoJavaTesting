package org.bedu.backend;

import java.util.LinkedList;
import java.util.List;

public class Database {

    private List<Product> db;

    public Database() {
        this.db = new LinkedList<>() ;
    }

    public void insert(Product data) {
        db.add(data);
    }

    public int size() {
        return db.size();
    }

    public Product getById(long id) {
        for (Product product : db) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    public void deleteByID(long id) {
        Product product =this.getById(id);
       if (product !=null)
        db.remove(product);
    }

    public void updateByID(int id, String newName) {
        if (this.getById(id) !=null)
            this.getById(id).setName(newName); ;
    }

    public void clear() {
        db.clear();
    }
}
