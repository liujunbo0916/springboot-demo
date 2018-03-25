package com.liujunbo.springbootdemo.utils;

import com.liujunbo.springbootdemo.entity.TSchool;
import com.liujunbo.springbootdemo.entity.TStudent;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ObjectMapRecover {

    /**
     *
     * 使用JDK中的 Introspector进行转换
     *
     *
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static Object mapToObject(Map<Object, Object> map, Class<?> beanClass) {
        if (map == null || map.size() == 0)
            return null;
        try {
            Object obj = beanClass.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo
                    .getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                Method setter = property.getWriteMethod();
                if (setter != null) {
                    setter.invoke(obj, map.get(property.getName()));
                }
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Object> objectToMap(Object obj) {
        try {
            if (obj == null)
                return null;
            Map<String, Object> map = new HashMap<String, Object>();
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo
                    .getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (key.compareToIgnoreCase("class") == 0) {
                    continue;
                }
                Method getter = property.getReadMethod();
                Object value = getter != null ? getter.invoke(obj) : null;
                map.put(key, value.toString());
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 第三方工具包实现 对象和map的相互转换
     *
     *
     */
    public static Object mapToObjectOfApache(Map<Object, Object> map,
                                             Class<?> beanClass)  {
        try{
            if (map == null || map.size() == 0)
                return null;
            Map<String, Object> dealMap = keyToStr(map);
            Object obj = beanClass.newInstance();
            BeanUtils.populate(obj, dealMap);
            return obj;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static Map<?, ?> objectToMapOfApache(Object obj) {
        if (obj == null)
            return null;
        Map<?, ?> map =  new BeanMap(obj);
        return map;
    }

    public static Map<String, Object> keyToStr(Map<Object, Object> map) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        for (Map.Entry<Object, Object> entry : map.entrySet())
            resultMap.put(entry.getKey().toString(), entry.getValue());
        return resultMap;
    }


    public static void main(String[] args) {
        TStudent student = new TStudent();
        student.setId(2);
        student.setsAddress("河南省罗山县");
        student.setsAge(22);
        student.setsClassCode("002");
        student.setsClassName("初中一年级");
        student.setsKeeper("liujunb");
        student.setsKeeperPhone("134324434");
        student.setsName("pant");
        student.setsNo("002");
        student.setsSex(1);
        TSchool school = new TSchool();
        school.setId(2);
        school.setScAddress("河南信阳");
        school.setScName("罗山高级中学");
        school.setScPhone("0755-9876789");
        Map<String,Object> map = (Map<String, Object>) objectToMap(student);
        for(Map.Entry<String, Object> entry:map.entrySet()){
            System.out.println("key:"+entry.getKey()+"   value:"+entry.getValue());
        }
    }
}
