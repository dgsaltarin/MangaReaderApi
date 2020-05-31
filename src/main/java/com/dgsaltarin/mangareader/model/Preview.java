package com.dgsaltarin.mangareader.model;

public class Preview {

    private String name;
    private String imageUrl;
    private int previewElementId;
    private String resourceLink;

    public Preview() {
    }

    public Preview(String name, String imageUrl, int previewElementId, String resourceLink) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.previewElementId = previewElementId;
        this.resourceLink = resourceLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPreviewElementId() {
        return previewElementId;
    }

    public void setPreviewElementId(int previewElementId) {
        this.previewElementId = previewElementId;
    }

    public String getResourceLink() {
        return resourceLink;
    }

    public void setResourceLink(String resourceLink) {
        this.resourceLink = resourceLink;
    }
}
