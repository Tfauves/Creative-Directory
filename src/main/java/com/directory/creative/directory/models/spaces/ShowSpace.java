package com.directory.creative.directory.models.spaces;

import javax.persistence.Entity;

@Entity
public class ShowSpace extends Space {
    private String galleryDescription;

    public ShowSpace() {
    }

    public ShowSpace (SpaceType type, String propertyName, String address, String neighborhood, String listing, Boolean waitList, String galleryDescription) {
        super(type, propertyName, address, neighborhood, listing, waitList);
        this.galleryDescription = galleryDescription;
    }

    public String getGalleryDescription() {
        return galleryDescription;
    }

    public void setGalleryDescription(String galleryDescription) {
        this.galleryDescription = galleryDescription;
    }
}
