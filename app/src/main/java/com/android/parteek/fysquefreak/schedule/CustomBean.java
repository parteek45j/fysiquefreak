package com.android.parteek.fysquefreak.schedule;

/**
 * Created by Suraj on 7/19/2017.
 */

public class CustomBean {
    String id;
    String name;
    String monday;

    public CustomBean() {
    }

    public CustomBean(String id, String name,String monday) {
        this.id = id;
        this.name = name;
        this.monday=monday;
    }

    public String getId1() {
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

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }
}
