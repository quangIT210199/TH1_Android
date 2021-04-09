package com.example.lab_01_ex2_listview.model;

public class Student {

    private String id, name, gender, date;
    private int img;

    public Student(String id, String name, String gender, String date, int img) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.img = img;
    }

    public Student() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
