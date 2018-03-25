package com.liujunbo.springbootdemo.utils;

import java.io.*;

public class SerializeUtil {

    /**
     * 使用jdk自带的对象输入输出流进行java的序列化和反序列化
     * @param obj
     * @return
     */
    public static byte[] serializeOfJdk(Object obj){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object unserializeOfJdk(byte[] objBytes){
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(objBytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
