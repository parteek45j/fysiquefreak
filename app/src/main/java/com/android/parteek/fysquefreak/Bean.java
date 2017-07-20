package com.android.parteek.fysquefreak;

/**
 * Created by suraj on 07-07-2017.
 */

public class Bean {

    String Title, Desc;
    int image;

    public Bean() {

    }
    public Bean(String title, int image) {
        Title = title;
        this.image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "Title='" + Title + '\'' +
                ", Desc='" + Desc + '\'' +
                ", image=" + image +
                '}';
    }
}

