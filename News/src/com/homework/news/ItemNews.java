package com.homework.news;

import java.util.Date;

/**
 * Created by Yushchenko on 26.09.2014.
 */
public class ItemNews {
    private String category;
    private String tittle;
    private int image;
    private Date date;

    public ItemNews(String category, String tittle, int image) {
        this.category = category;
        this.tittle = tittle;
        this.image = image;
    }

    public String getCategory() {
        return this.category;
    }

    public String getTittle() {
        return this.tittle;
    }

    public String getDate() {
        return "18:23";
    }

    public int getImg() {
        return this.image;
    }
}
