package com.directory.creative.directory.models.spaces;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private SpaceType type;
    private String propertyName;
    private String address;
    private String neighborhood;
    private String listing;
    private Boolean waitList;

    public Space () {}

    public Space(SpaceType type, String propertyName, String address, String neighborhood, String listing, Boolean waitList) {
        this.type = type;
        this.propertyName = propertyName;
        this.address = address;
        this.neighborhood = neighborhood;
        this.listing = listing;
        this.waitList = waitList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SpaceType getType() {
        return type;
    }

    public void setType(SpaceType type) {
        this.type = type;
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

    public Boolean getWaitList() {
        return waitList;
    }

    public void setWaitList(Boolean waitList) {
        this.waitList = waitList;
    }
}
