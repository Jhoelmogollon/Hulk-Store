package com.kardex.hulkstore.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "purchase")
public class Purchase {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sell")
    private Integer idPurchase;

    @Column(name = "id_user")
    private String idCustomer;

    @Column(name = "date_purchase")
    private LocalDateTime datePurchase;

    @Column(name = "payment-method")
    private String paymentMethod;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private Users user;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.ALL})
    private List<PurchaseProduct> products;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<PurchaseProduct> getProducts() {
        return products;
    }

    public void setProducts(List<PurchaseProduct> products) {
        this.products = products;
    }

    public Integer getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Integer idPurchase) {
        this.idPurchase = idPurchase;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public LocalDateTime getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(LocalDateTime datePurchase) {
        this.datePurchase = datePurchase;
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
}
