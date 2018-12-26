package com.zking.ssm.service;

import com.zking.ssm.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderService {
    Order querySingleOrder(Integer OrderId);
}