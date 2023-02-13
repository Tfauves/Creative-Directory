package com.directory.creative.directory.models.spaces;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class LiveWorkSpace extends Space {
    private String bedroom;
    private String bathroom;

    public LiveWorkSpace() {
    }

    public LiveWorkSpace(SpaceType type, String propertyName, String address, String neighborhood, String listing, Boolean waitList, String bedroom, String bathroom) {
        super(type, propertyName, address, neighborhood, listing, waitList);
        this.bedroom = bedroom;
        this.bathroom = bathroom;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public String getBathroom() {
        return bathroom;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }
}
