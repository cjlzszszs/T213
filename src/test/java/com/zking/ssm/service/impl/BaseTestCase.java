package com.zking.ssm.service.impl;

import com.zking.ssm.model.Customer;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class BaseTestCase {
    private Customer customer;


    public  void setUp(){
        customer=new Customer();
    }
}
