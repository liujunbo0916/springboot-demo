package com.liujunbo.springbootdemo.service.busi;

import com.liujunbo.springbootdemo.entity.TStudent;

import java.util.List;

public interface StudentService {

    List<TStudent> selectByCondition(TStudent student);

    TStudent getById(Integer id);

    int updateByPrimaryKeySelective(TStudent student);

    int insert(TStudent student);
}
