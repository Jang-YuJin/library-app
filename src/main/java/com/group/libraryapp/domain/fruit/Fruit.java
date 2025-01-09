package com.group.libraryapp.domain.fruit;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fruit")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id = null;
    @Column(nullable = false, length = 25)
    String name;
    @Column(name = "warehousingdate")
    LocalDate warehousingDate;
    @Column
    Long price;
    @Column(name = "saleyn")
    String saleYn;

    protected Fruit() {}

    public Fruit(String name, LocalDate warehousingDate, Long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }
//
//    public Fruit(Long price, String saleYn) {
//        this.price = price;
//        this.saleYn = saleYn;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWarehousingDate(LocalDate warehousingDate) {
        this.warehousingDate = warehousingDate;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setSaleYn(String saleYn) {
        this.saleYn = saleYn;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public Long getPrice() {
        return price;
    }

    public String getSaleYn() {
        return saleYn;
    }
}
