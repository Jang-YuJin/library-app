package com.group.libraryapp.dto.response;

public class FruitResponse {
    long price;
    String saleYn;

    public void setPrice(long price) {
        this.price = price;
    }

    public void setSaleYn(String saleYn) {
        this.saleYn = saleYn;
    }

    public long getPrice() {
        return price;
    }

    public String getSaleYn() {
        return saleYn;
    }

    public FruitResponse(long pring, String saleYn) {
        this.price = pring;
        this.saleYn = saleYn;
    }
}
