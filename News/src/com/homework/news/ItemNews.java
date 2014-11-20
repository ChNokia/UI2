package com.homework.news;

import java.util.Date;

public class ItemNews {
    private String category;
    private String title;
    private int image;
    private Date date;

    public ItemNews(String category, String title, int image) {
        this.category = category;
        this.title = title;
        this.image = image;
    }

    public String getCategory() {
        return this.category;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDate() {
        return "18:23";
    }

    public int getImg() {
        return this.image;
    }
}
