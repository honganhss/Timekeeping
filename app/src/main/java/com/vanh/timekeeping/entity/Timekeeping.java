package com.vanh.timekeeping.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;
//tạo khóa ngoại
//@Entity(foreignKeys = {
//        @ForeignKey(entity = Staff.class,
//        parentColumns = "idStaff",
//        childColumns = "idStaff",
//        onDelete = ForeignKey.CASCADE),
//        @ForeignKey(entity = Status.class,
//                parentColumns = "idStatus",
//                childColumns = "idStatus",
//                onDelete = ForeignKey.CASCADE),
//        @ForeignKey(entity = User.class,
//                parentColumns = "idUser",
//                childColumns = "createBy",
//                onDelete = ForeignKey.CASCADE)
//        })
@Entity
public class Timekeeping {
    @PrimaryKey
    @NonNull
    private int id;
    private String timekeepingDay;
    private String idStaff;
    private int idStatus;
    private int createBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimekeepingDay() {
        return timekeepingDay;
    }

    public void setTimekeepingDay(String timekeepingDay) {
        this.timekeepingDay = timekeepingDay;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public Timekeeping(int id, String timekeepingDay, String idStaff, int idStatus, int createBy) {
        this.id = id;
        this.timekeepingDay = timekeepingDay;
        this.idStaff = idStaff;
        this.idStatus = idStatus;
        this.createBy = createBy;
    }
}
