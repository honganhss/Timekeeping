package com.vanh.timekeeping.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Status {
    @PrimaryKey
    @NonNull
    public int idStatus;
    public String statusName;

}
