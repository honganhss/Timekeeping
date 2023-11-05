package com.vanh.timekeeping.database;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vanh.timekeeping.entity.User;

import java.util.List;

public interface UserDAO {
    @Insert
    void inserUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM User")
    List<User> getAllUser();
}
