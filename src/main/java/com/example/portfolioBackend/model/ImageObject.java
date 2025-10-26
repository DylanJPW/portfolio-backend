package com.example.portfolioBackend.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class ImageObject {
    private String imageUrl;

    private String altText;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }
}

