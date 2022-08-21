package com.directory.creative.directory.models.spaces;

public abstract class Space {
    private String propertyName;
    private String address;
    private String neighborhood;
    private String listing;
    private String totalArtistUnits;
    private String rentOrOwn;
    private Boolean waitList;

    public Space() {
    }

    public Space(String propertyName, String address, String neighborhood, String listing, String totalArtistUnits, String rentOrOwn, Boolean waitList) {
        this.propertyName = propertyName;
        this.address = address;
        this.neighborhood = neighborhood;
        this.listing = listing;
        this.totalArtistUnits = totalArtistUnits;
        this.rentOrOwn = rentOrOwn;
        this.waitList = waitList;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getListing() {
        return listing;
    }

    public void setListing(String listing) {
        this.listing = listing;
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

    public Boolean getWaitList() {
        return waitList;
    }

    public void setWaitList(Boolean waitList) {
        this.waitList = waitList;
    }
}
