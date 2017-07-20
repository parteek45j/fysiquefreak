package com.android.parteek.fysquefreak.schedule;

/**
 * Created by Suraj on 7/7/2017.
 */

public class ScheduleBean {
    String name;
    int image;
    boolean selected=false;

    public ScheduleBean() {
    }

    public ScheduleBean(String name, int image, boolean selected) {
        this.name = name;
        this.image = image;
        this.selected = selected;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
