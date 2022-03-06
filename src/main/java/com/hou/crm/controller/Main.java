package com.hou.crm.controller;

import com.hou.crm.pojo.BaseDict;
import com.hou.crm.pojo.Customer;
import com.hou.crm.pojo.QueryVo;
import com.hou.crm.service.CustomerService;
import com.hou.crm.service.DicService;
import com.hou.crm.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/crm")
public class Main {
    /*crm.properties的变量值引用*/
    @Value("${customer_from_type}")
    private String fromType;
    @Value("${customer_industry_type}")
    private String industryType;
    @Value("${customer_level_type}")
    private String levelType;

    @Autowired
    private DicService dicService;
    @Autowired
    private CustomerService customerService;

/*    public Customer */
    @GetMapping("/list")
    public ModelAndView list(QueryVo vo){
        /*三次查询搜索栏的类型，行业，级别*/
        System.out.println("customer_industry_type");
        System.out.println(vo);
        ModelAndView mv=new ModelAndView();
        List<BaseDict> fromTypes = dicService.findByTypeCode(fromType);
        List<BaseDict> industryTypes = dicService.findByTypeCode(industryType);
        List<BaseDict> levelTypes = dicService.findByTypeCode(levelType);
        vo.setStart((vo.getPage()-1)*vo.getRows());
        int total = customerService.findCount(vo);
        List<Customer> customers = customerService.findByDic(vo);
//        System.out.println(customers);
        mv.addObject("fromType",fromTypes);
        mv.addObject("industryType",industryTypes);
        mv.addObject("levelType",levelTypes);

        Page<Customer> page = new Page<>(total,vo.getPage(),vo.getRows(),customers);
        mv.addObject("page",page);
        mv.addObject("vo",vo);
        mv.setViewName("customer");


        return mv;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public Customer edit(int id){
        Customer customer = customerService.getCustomerByid(id);
        return customer;
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Customer customer){
        /*默认是更新失败的*/
        String msg= "1";
        try {
            customerService.updateCustomer(customer);
            msg = "0";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("更新失败");
        }
        return msg;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(int id){
        /*默认是删除失败的*/
        String msg= "1";
        try {
            customerService.deleteCustomer(id);
            msg = "0";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除失败");
        }
        return msg;
    }
}
