package com.hou.crm.service;

import com.hou.crm.pojo.Customer;
import com.hou.crm.pojo.QueryVo;

import java.util.List;

public interface CustomerService {

    List<Customer> findByDic(QueryVo vo);
    int findCount(QueryVo vo);
    Customer getCustomerByid(int id);
    Void updateCustomer(Customer customer);
    Void deleteCustomer(int id);
}
