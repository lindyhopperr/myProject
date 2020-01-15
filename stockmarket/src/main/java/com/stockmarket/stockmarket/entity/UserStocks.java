package com.stockmarket.stockmarket.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "userstocks")
public class UserStocks {

    private Long id;
    private Long userId;
    private Long stockId;
    private Long count;

    public UserStocks() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "userid", nullable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "stockid", nullable = false)
    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    @Column(name = "count")
    @ColumnDefault(value = "0")
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        if (count >= 0) {
            this.count = count;
        }
    }
}
