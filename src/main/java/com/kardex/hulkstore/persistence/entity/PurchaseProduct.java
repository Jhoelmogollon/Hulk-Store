package com.kardex.hulkstore.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "purchase_product")
public class PurchaseProduct {

    @EmbeddedId
    private PurchaseProductPK id;

    private Integer amount;
    private Double total;
    private Boolean status;

    @ManyToOne
    @MapsId("idPurchase")
    @JoinColumn(name = "id_sell", insertable = false, updatable = false)
    private Purchase sell;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;

    public Purchase getSell() {
        return sell;
    }

    public void setSell(Purchase sell) {
        this.sell = sell;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PurchaseProductPK getId() {
        return id;
    }

    public void setId(PurchaseProductPK id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
