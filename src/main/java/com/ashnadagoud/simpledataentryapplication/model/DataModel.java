package com.ashnadagoud.simpledataentryapplication.model;

public class DataModel {
    private String name;
    private String age; //intentionally set age as string to prevent type mismatch exception from UI
    private String title;
    private String hometown;

    //getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
}
