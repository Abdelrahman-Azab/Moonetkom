package com.example.android.moonetkom;

public class Modelitems {
    Integer imageresource;
    String descriptiomn;
    String pricee;

    public Modelitems(Integer imageresource, String descriptiomn, String pricee) {
        this.imageresource = imageresource;
        this.descriptiomn = descriptiomn;
        this.pricee = pricee;
    }

    public Integer getImageresource() {
        return imageresource;
    }

    public void setImageresource(Integer imageresource) {
        this.imageresource = imageresource;
    }

    public String getDescriptiomn() {
        return descriptiomn;
    }

    public void setDescriptiomn(String descriptiomn) {
        this.descriptiomn = descriptiomn;
    }

    public String getPricee() {
        return pricee;
    }

    public void setPricee(String pricee) {
        this.pricee = pricee;
    }
}
