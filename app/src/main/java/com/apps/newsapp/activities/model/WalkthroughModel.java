package com.apps.newsapp.activities.model;

import android.widget.ImageView;

public class WalkthroughModel {

    private String title,desc;
    private int image;

    public WalkthroughModel(String title, String desc, int image) {
        this.title = title;
        this.desc = desc;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public WalkthroughModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public WalkthroughModel setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public int getImage() {
        return image;
    }

    public WalkthroughModel setImage(int image) {
        this.image = image;
        return this;
    }
}
