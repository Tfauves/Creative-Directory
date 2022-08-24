package com.directory.creative.directory.models.spaces;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WorkOnlySpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String propertyName;
    private String address;
    private String neighborhood;
    private String listing;
    private String totalArtistUnits;
    private String rentOrOwn;
    private Boolean waitList;

    public WorkOnlySpace() {
    }

    public WorkOnlySpace(String propertyName, String address, String neighborhood, String listing, String totalArtistUnits, String rentOrOwn, Boolean waitList) {
        this.propertyName = propertyName;
        this.address = address;
        this.neighborhood = neighborhood;
        this.listing = listing;
        this.totalArtistUnits = totalArtistUnits;
        this.rentOrOwn = rentOrOwn;
        this.waitList = waitList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
