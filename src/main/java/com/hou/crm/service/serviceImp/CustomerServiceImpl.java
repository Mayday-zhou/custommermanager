package com.hou.crm.service.serviceImp;

import com.hou.crm.mapper.CustomerMapper;
import com.hou.crm.pojo.Customer;
import com.hou.crm.pojo.QueryVo;
import com.hou.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl  implements CustomerService{

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> findByDic(QueryVo vo) {
        return customerMapper.findByDict(vo);
    }

    @Override
    public int findCount(QueryVo vo) {
        return customerMapper.findCount(vo);
    }

    @Override
    public Customer getCustomerByid(int id) {
        return customerMapper.getCustomerByid(id);
    }

    @Override
    public Void updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public Void deleteCustomer(int id) {
        return customerMapper.deleteCustomer(id);
    }
}
