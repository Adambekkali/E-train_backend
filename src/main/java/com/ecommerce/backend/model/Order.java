package com.ecommerce.backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "store_product_id", nullable = false)
    private StoreProduct storeProduct;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @Column(name = "customer_name", nullable = false, length = Integer.MAX_VALUE)
    private String customerName;

    @Column(name = "customer_country", nullable = false, length = Integer.MAX_VALUE)
    private String customerCountry;

    @Column(name = "order_total", nullable = false, precision = 12, scale = 2)
    private BigDecimal orderTotal;

    @ColumnDefault("'pending'")
    @Column(name = "order_status", nullable = false, length = Integer.MAX_VALUE)
    private String orderStatus;

    @ColumnDefault("'not_started'")
    @Column(name = "delivery_status", nullable = false, length = Integer.MAX_VALUE)
    private String deliveryStatus;

    @Column(name = "expected_delivery_day")
    private Integer expectedDeliveryDay;

    @Column(name = "actual_delivery_day")
    private Integer actualDeliveryDay;

    @ColumnDefault("0")
    @Column(name = "hidden_delay_risk", nullable = false, precision = 5, scale = 2)
    private BigDecimal hiddenDelayRisk;

    @ColumnDefault("0")
    @Column(name = "hidden_loss_risk", nullable = false, precision = 5, scale = 2)
    private BigDecimal hiddenLossRisk;

    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @ColumnDefault("now()")
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public StoreProduct getStoreProduct() {
        return storeProduct;
    }

    public void setStoreProduct(StoreProduct storeProduct) {
        this.storeProduct = storeProduct;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Integer getExpectedDeliveryDay() {
        return expectedDeliveryDay;
    }

    public void setExpectedDeliveryDay(Integer expectedDeliveryDay) {
        this.expectedDeliveryDay = expectedDeliveryDay;
    }

    public Integer getActualDeliveryDay() {
        return actualDeliveryDay;
    }

    public void setActualDeliveryDay(Integer actualDeliveryDay) {
        this.actualDeliveryDay = actualDeliveryDay;
    }

    public BigDecimal getHiddenDelayRisk() {
        return hiddenDelayRisk;
    }

    public void setHiddenDelayRisk(BigDecimal hiddenDelayRisk) {
        this.hiddenDelayRisk = hiddenDelayRisk;
    }

    public BigDecimal getHiddenLossRisk() {
        return hiddenLossRisk;
    }

    public void setHiddenLossRisk(BigDecimal hiddenLossRisk) {
        this.hiddenLossRisk = hiddenLossRisk;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}