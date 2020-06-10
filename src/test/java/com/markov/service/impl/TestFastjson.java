package com.markov.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.markov.config.Config;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@ContextConfiguration(classes = Config.class)

public class TestFastjson {


    @Test
    public void test() throws IOException, ClassNotFoundException {
        ParserConfig.getGlobalInstance().setSafeMode(false);

        JSONObject map=new JSONObject(true);
        HashMap<String, Object> testmap = new HashMap<String,Object>();
        testmap.put("B", 2);
        testmap.put("A", 1);
        testmap.put("C", 3);
        String jsonString = JSONObject.toJSONString(testmap,true);
        System.out.println(jsonString);
        HashMap<String, Object> test=JSONObject.parseObject(jsonString, HashMap.class);
        System.out.println(test);
        System.out.println(ParserConfig.getGlobalInstance().isSafeMode());


//
//
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.put("A",1);
//        jsonObject.put("B",1);
//        Integer testint=new Integer(2);
//
//        JSONObject jsonObject2=new JSONObject();
//        jsonObject.put("A",1);
//        jsonObject.put("B",1);
//
//
//        ByteArrayOutputStream bos=new ByteArrayOutputStream();
//        ObjectOutputStream oos=new ObjectOutputStream(bos);
//        oos.writeObject(jsonObject);
//
//        ParserConfig.getGlobalInstance().setSafeMode(true);
//
//
//        ByteArrayOutputStream bos2=new ByteArrayOutputStream();
//        ObjectOutputStream oos2=new ObjectOutputStream(bos2);
//        oos2.writeObject(jsonObject2);
//
//        ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
//        ObjectInputStream ois =new ObjectInputStream(bis);
//
//        ByteArrayInputStream bis2=new ByteArrayInputStream(bos.toByteArray());
//        ObjectInputStream ois2 =new ObjectInputStream(bis2);
//
//        ParserConfig.getGlobalInstance().setSafeMode(false);
//        Object o2=ois2.readObject();
//        Object o1=ois.readObject();
//        System.out.println(o1.toString());


    }

}
