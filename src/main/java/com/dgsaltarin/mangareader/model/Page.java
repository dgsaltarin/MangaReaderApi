package com.dgsaltarin.mangareader.model;

public class Page {

    public final String BASE_URL = "https://res.cloudinary.com/dgmanga/image/upload/v1590027250";

    private String pageUrl;

    public Page() {
    }

    public Page(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }
}
