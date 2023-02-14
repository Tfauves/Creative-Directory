package com.directory.creative.directory.models.spaces;

import javax.persistence.Entity;

@Entity
public class WorkOnlySpace extends Space {
    private String totalArtistUnits;
    private String rentOrOwn;

    public WorkOnlySpace() {
    }

    public WorkOnlySpace(SpaceType type, String propertyName, String address, String neighborhood, String listing, Boolean waitList, String totalArtistUnits, String rentOrOwn) {
        super(type, propertyName, address, neighborhood, listing, waitList);
        this.totalArtistUnits = totalArtistUnits;
        this.rentOrOwn = rentOrOwn;

    }

    public String getTotalArtistUnits() {
        return totalArtistUnits;
    }

    public void setTotalArtistUnits(String totalArtistUnits) {
        this.totalArtistUnits = totalArtistUnits;
    }

    public String getRentOrOwn() {
        return rentOrOwn;
    }

    public void setRentOrOwn(String rentOrOwn) {
        this.rentOrOwn = rentOrOwn;
    }
}
