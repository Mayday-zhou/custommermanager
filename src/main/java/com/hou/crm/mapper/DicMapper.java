package com.hou.crm.mapper;

import com.hou.crm.pojo.BaseDict;

import java.util.List;

public interface DicMapper {
    List<BaseDict> findByTypeCode(String id);

}
