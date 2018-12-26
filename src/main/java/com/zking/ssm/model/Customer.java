package com.zking.ssm.model;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Customer {
    private Integer customerId;

    private String customerName;

    private List<Order> order=new ArrayList<Order>();

    public List<Order> getOrder() {
        return order;
    }

    public Customer setOrder(List<Order> order) {
        this.order = order;
        return this;
    }

    public Customer(Integer customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public Customer() {
        super();
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}