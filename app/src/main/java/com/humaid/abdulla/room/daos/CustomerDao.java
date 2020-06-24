package com.humaid.abdulla.room.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.humaid.abdulla.room.tables.CustomerTable;

@Dao
public interface CustomerDao {
    @Query("SELECT * FROM CustomerTable")
    java.util.List<CustomerTable> getAllpeople();

    @Query("SELECT COUNT(id) FROM CustomerTable WHERE 1")
    int getNumberofEventPeople();

    @Query("DELETE FROM CustomerTable WHERE id=:id")
    void hasDeleted(String id);


    @Query("SELECT * FROM CustomerTable WHERE 1")
    java.util.List<CustomerTable> getAllofEventPeople();

    @Insert
    void insert(CustomerTable peopleTable);

    @Delete
    void delete(CustomerTable peopleTable);

    @Update
    void update(CustomerTable peopleTable);
}
