package com.liujunbo.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UrlTestController {


    @RequestMapping("testUrl")
    String testUrl(Model model){
        model.addAttribute("host","http://www.baidu.com");
        List<String> list = new ArrayList<String>();
        list.add("liujunbo");
        list.add("panting");
        System.out.println(list.get(0));
        return "/index";
    }


}
