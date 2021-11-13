package com.kardex.hulkstore.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Purchase {
    private int idPurchase;
    private String idUser;
    private LocalDateTime date;
    private String paymentMethod;
    private Boolean status;

    private List<PurchaseItem> items;

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<PurchaseItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseItem> item) {
        this.items = items;
    }
}
