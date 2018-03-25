package com.liujunbo.springbootdemo.controller;

import com.liujunbo.springbootdemo.service.busi.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UrlTestController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("testUrl")
    String testUrl(Model model){
        model.addAttribute("host","http://www.baidu.com");
        List<String> list = new ArrayList<String>();
        list.add("liujunbo");
        list.add("panting");
        System.out.println(list.get(0));
        return "/index";
    }
    @RequestMapping("getById")
    String getById(Integer id){
        studentService.getById(id);
        return "/index";
    }
}
