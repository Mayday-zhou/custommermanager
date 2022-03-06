package com.hou.crm.mapper;

import com.hou.crm.pojo.Customer;
import com.hou.crm.pojo.QueryVo;

import java.util.List;

public interface CustomerMapper {
    /**
     * k查询查询条件，分类查询用户列表
     * 查询总记录数
     * @param vo
     * @return
     */
    List<Customer> findByDict(QueryVo vo);
    int findCount(QueryVo vo);
/*根据用户id查询用户信息*/
    Customer getCustomerByid(int id);
    Void updateCustomer(Customer customer);
    /*根据用户id删除用户信息*/
    Void deleteCustomer(int id);
}
