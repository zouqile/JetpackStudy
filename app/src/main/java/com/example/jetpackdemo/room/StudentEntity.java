package com.example.jetpackdemo.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class StudentEntity {

    public StudentEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //主键（自增长）
    @PrimaryKey(autoGenerate = true)
    private int id;

    //可以声明列的名称
    @ColumnInfo(name = "stu_name")
    private String name;

    //可以不声明列的名称，按字段名称
    private int age;


    private int test;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }
}
