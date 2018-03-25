package com.liujunbo.springbootdemo.service.busi.impl;

import com.liujunbo.springbootdemo.dao.TStudentMapper;
import com.liujunbo.springbootdemo.entity.TStudent;
import com.liujunbo.springbootdemo.service.busi.StudentService;
import com.liujunbo.springbootdemo.service.cache.redis.RedisService;
import com.liujunbo.springbootdemo.utils.ObjectMapRecover;
import com.liujunbo.springbootdemo.utils.RedisKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private TStudentMapper studentMapper;

    @Autowired
    private RedisService redisService;

    public List<TStudent> selectByCondition(TStudent student){
        return studentMapper.selectByCondition(student);
    }
    public TStudent getById(Integer id){
        String key = RedisKeyUtils.RedisSchool.STUDENT_KEY+id;
        TStudent persistence = (TStudent) ObjectMapRecover.mapToObjectOfApache(redisService.hAllGet(key), TStudent.class);
        if(persistence == null){
            persistence =  studentMapper.selectByPrimaryKey(id);
        }
        if(!redisService.exists(key)){
            Map<String,Object> redisHash = (Map<String, Object>) ObjectMapRecover.objectToMap(persistence);
            redisService.hAllSet(key, redisHash);
            redisService.expire(key, 120L);
        }
        return persistence;
    }
    public int updateByPrimaryKeySelective(TStudent student){
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    public int insert(TStudent student){
        return studentMapper.insert(student);
    }
}
