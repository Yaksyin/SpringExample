package com.kopi.learning_spring_yaksyin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.util.Scanner;

@Entity
 @Table(name = "data_kopi", schema = "public")
public class SellerEntitiy {

    @Id
    @Column(name = "coffe_id", nullable = false, length = 70)
    private String coffeId;

    @Column(name = "coffe_type", nullable = false, length = 70)
    private String coffeType;

    @Column(name = "seller_name", nullable = false, length = 70)
    private String sellerName;

    @Column(name = "seller_id", nullable = false, length = 70)
    private Integer sellerId;

    @Column(name = "product_name", nullable = false, length = 70)
    private String productName;

    @Column(name = "product_id", nullable = false, length = 70)
    private Integer productId;

    @Column(name = "created_at", nullable = false, length = 70)
    private Timestamp createdAt;

    @Column(name = "created_by", nullable = false, length = 70)
    private String createdBy;

    @Column(name = "id", nullable = false, length = 70)
    private String id;

    // Getters and Setters

    public String getCoffeId () {
            return coffeId;
        }

        public String getCoffeType () {
            return coffeType;
        }

        public String getSellerName () {
            return sellerName;
        }

        public Integer getSellerId () {
            return sellerId;
        }

        public String getProductName () {
            return productName;
        }

        public Integer getProductId () {
            return productId;
        }

        public Timestamp getCreatedAt () {
            return createdAt;
        }

        public String getCreatedBy () {
            return createdBy;
        }

        public String getId () {
            return id;
        }

        public void setCoffeId (String coffeId){
            this.coffeId = coffeId;
        }

        public void setCoffeType (String coffeType){
            this.coffeType = coffeType;
        }

        public void setSellerName (String sellerName){
            this.sellerName = sellerName;
        }

        public void setSellerId (Integer sellerId){
            this.sellerId = sellerId;
        }

        public void setProductName (String productName){
            this.productName = productName;
        }

        public void setProductId (Integer productId){
            this.productId = productId;
        }

        public void setCreatedAt (Timestamp createdAt){
            this.createdAt = createdAt;
        }

        public void setCreatedBy (String createdBy){
            this.createdBy = createdBy;
        }

        public void setId (String id){
            this.id = id;

    }
}
