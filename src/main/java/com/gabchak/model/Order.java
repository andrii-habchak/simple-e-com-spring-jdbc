package com.gabchak.model;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class Order {

    private Long orderId;
    private User customer;
    private Calendar orderDate;
    private String orderComment;
    private Double orderAmount;
    private List<Product> products;
    private Map<Long, Integer> productsQuantity;

    public Order() {
    }

    public Order(Long orderId, User customer, Calendar orderDate, String orderComment, Double orderAmount, List<Product> products, Map<Long, Integer> productsQuantity) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderComment = orderComment;
        this.orderAmount = orderAmount;
        this.products = products;
        this.productsQuantity = productsQuantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Map<Long, Integer> getProductsQuantity() {
        return productsQuantity;
    }

    public void setProductsQuantity(Map<Long, Integer> productsQuantity) {
        this.productsQuantity = productsQuantity;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }
}