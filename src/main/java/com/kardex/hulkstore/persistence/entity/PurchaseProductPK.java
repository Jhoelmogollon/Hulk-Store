package com.kardex.hulkstore.persistence.entity;

import javax.persistence.*;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PurchaseProductPK implements Serializable {

    @Column(name = "id_sell")
    private Integer idSell;

    @Column(name = "id_product")
    private Integer idProduct;

    public Integer getIdSell() {
        return idSell;
    }

    public void setIdSell(Integer idSell) {
        this.idSell = idSell;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }
}
