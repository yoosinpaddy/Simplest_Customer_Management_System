package com.humaid.abdulla.room.config;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.humaid.abdulla.room.daos.CustomerDao;
import com.humaid.abdulla.room.tables.CustomerTable;


@Database(entities = {CustomerTable.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CustomerDao customerDao();


}
