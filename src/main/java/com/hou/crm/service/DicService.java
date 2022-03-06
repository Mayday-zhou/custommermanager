package com.hou.crm.service;

import com.hou.crm.pojo.BaseDict;

import java.util.List;

public interface DicService {
    List<BaseDict> findByTypeCode(String id);
}
