package org.bedu.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

 //Arrange
    private Database db;

    @BeforeEach
    public void setUp(){
        db= new Database();
    }

    @Test
    @DisplayName("The size of an empty data base is 0")
    public void sizeZero(){
        assertEquals(db.size(),0);
    }

    @Test
    @DisplayName("Data base can insert data")
    public void insert(){
        db.insert(new Product (1,"Coca Cola"));
        db.insert(new Product(2,"Gansito"));

        assertEquals(db.size(),2);
    }

    @Test
    @DisplayName("Data base can seach by ID")
    public void findByID(){
        db.insert(new Product(1,"Coca Cola"));
        db.insert(new Product(2,"Gansito"));
        db.insert(new Product(3,"Mordisco"));
        db.insert(new Product(4,"Sabritas"));

        Product  p = db.getById(3);

        assertEquals(p.getId(),3);
        assertEquals(p.getName(),"Mordisco");
    }

    @Test
    @DisplayName("Data base can seach by ID")
    public void clearDB(){
        db.insert(new Product(1,"Coca Cola"));
        db.insert(new Product(2,"Gansito"));
        db.insert(new Product(3,"Mordisco"));
        db.insert(new Product(4,"Sabritas"));

        assertEquals(db.size(),4);

        db.clear();
        assertEquals(db.size(),0);

    }
}