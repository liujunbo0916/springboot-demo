package com.liujunbo.springbootdemo.service.cache.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;
    //########################String操作开始（后期方法可以在该模块中扩展）#####################################
    /**
     * string类型的 放入
     * @param key
     * @param value
     * @return
     */
    public boolean  set(String key,String value){
        boolean result = false;
        try{
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * String 类型
     * 写入缓存设置失效时间
     */
    public boolean set(String key,String value,Long expireTime){
        boolean result = false;
        try{
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**string 类型
     * 批量删除对应的value
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**string 类型
     * 批量删除key
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**string 类型
     * 删除对应的value
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * string 类型
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }


    /**string 类型
     * 读取缓存
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }
    //########################String操作结束#####################################
    //########################hash操作#####################################
    /**
     * 哈希 添加
     * @param key
     * @param hashKey
     * @param value
     */
    public void hmSet(String key, Object hashKey, Object value){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key,hashKey,value);
    }
    /**
     * hash 当一个值不存在时添加
     * 对应命令 HSETNX
     */
    public void hmSetOfAbsent(String key, Object hashKey, Object value){
        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        hash.putIfAbsent(key, hashKey, value);
    }

    /**
     * hash多值添加
     * 对应命令 hmset
     * @param key
     * @param entitys
     */
    public void hAllSet(String key,Map<String,Object> entitys){
        if(entitys == null || entitys.size() == 0){
            return;
        }
        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        for(Map.Entry<String,Object> entry:entitys.entrySet()){
            entitys.put(entry.getKey(), entry.getValue().toString());
        }
        hash.putAll(key, entitys);
    }
    /**
     * hash获取整个hash的key和value
     *
     * 对应的命令hgetAll
     *
     */
    public Map<Object, Object> hAllGet(String key){
        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        return hash.entries(key);
    }
    /**
     * 哈希获取数据
     * @param key
     * @param hashKey
     * @return
     */
    public Object hmGet(String key, Object hashKey){
        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        return hash.get(key,hashKey);
    }

    /**
     * 返回一个hash的大小
     * @param key
     * @return
     */
    public Long hmLen(String key){
        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        return hash.size(key);
    }

    //########################hash操作结束#####################################

    //########################list操作（后期方法可以在该模块中扩展）#####################################
    /**
     * 列表添加
     * @param k
     * @param v
     */
    public void lPush(String k,Object v){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k,v);
    }

    /**
     * 列表获取
     * @param k
     * @param l
     * @param l1
     * @return
     */
    public List<Object> lRange(String k, long l, long l1){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k,l,l1);
    }

    //########################list操作结束#####################################

    //########################set操作开始（后期方法可以在该模块中扩展）#####################################
    /**
     * set集合添加
     * @param key
     * @param value
     */
    public void add(String key,Object value){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key,value);
    }

    /**
     * 集合获取
     * @param key
     * @return
     */
    public Set<Object> setMembers(String key){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }


    /**
     * 有序集合添加
     * @param key
     * @param value
     * @param scoure
     */
    public void zAdd(String key,Object value,double scoure){
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key,value,scoure);
    }

    /**
     * 有序集合获取
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public Set<Object> rangeByScore(String key,double scoure,double scoure1){
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }
    //########################set操作结束#####################################
    /**
     * 对于key的操作
     * 批量移除key的过期时间
     */
    public void removeExpire(String ... keys){
        for(String key : keys){
            removeExpire(key);
        }
    }
    /**
     * 对于key的操作
     * 移除指定key的过期时间
     * @param key
     */
    public void removeExpire(String key){
        if(exists(key)){
            redisTemplate.persist(key);
        }
    }
    public void expire(String key,Long time){
        if(exists(key)){
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }
    /**
     * 对于key的操作
     * 查找所有符合给定模式pattern（正则表达式）的 key
     * 对应 命令  keys   *o*
     * keys查询速度很快  但是是阻塞命令 所以在生产环境谨慎使用
     */
    public Set<String> keys(String pattern){
        return redisTemplate.keys(pattern);
    }

}
