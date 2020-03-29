package com.example.androiddevproject.sqlite;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM userentity")
    List<UserEntity> getAll();

    @Insert
    void insert(UserEntity user);

    @Query("DELETE FROM userentity")
    void deletAll();

}
