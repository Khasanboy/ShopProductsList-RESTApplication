package com.sszkoluda.shopproductslist.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "product")
public class Product {

    @Getter
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Getter
    @Column(name = "product_name")
    private String productName;

    @Getter
    @Column(name = "frequency_of_use")
    private Integer frequencyOfUse;

    @Getter
    @Column(name = "amount")
    private Integer amount;

    @Getter
    @Column(name = "in_stock")
    private Integer inStock;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="family_id", nullable=false)
    @JsonIgnoreProperties("productsList")
    private Family family;


}
