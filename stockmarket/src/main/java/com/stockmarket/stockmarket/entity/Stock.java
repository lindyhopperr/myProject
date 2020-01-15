package com.stockmarket.stockmarket.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stocks")
public class Stock {

    private Long id;
    private String code;
    private String name;
    private Date createdDate;

    private Double price;
    private Date lastModifiedDate;

    public Stock() {
        this.createdDate = new Date();
        this.lastModifiedDate = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "code", nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "created_date")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", price=" + price +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
