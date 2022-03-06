package com.hou.crm.service.serviceImp;

import com.hou.crm.mapper.DicMapper;
import com.hou.crm.pojo.BaseDict;
import com.hou.crm.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DicServiceImp implements DicService {
    @Autowired
    private DicMapper dicMapper;
    public List<BaseDict> findByTypeCode(String id) {
        return dicMapper.findByTypeCode(id);
    }
}
