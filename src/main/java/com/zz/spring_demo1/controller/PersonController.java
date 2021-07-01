package com.zz.spring_demo1.controller;

import com.zz.spring_demo1.model.Person;
import com.zz.spring_demo1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    // 设置访问路由值为路径
    @RequestMapping("/person")
    public ModelAndView index(){
        // 顾名思义 实体和数据 同时返回页面模板和数据
        System.out.println("12321");
        ModelAndView mav = new ModelAndView("index");
        List<Person> list = personService.getAll();
        mav.addObject("list",list);

        System.out.println("qwer");
        System.out.println(mav);
        return mav;
    }

    // 设置访问路由值为路径
    @RequestMapping("/personlist")
    public List<Person> indexlist(){
        // 顾名思义 实体和数据 同时返回页面模板和数据
        System.out.println("12321");
        List<Person> list = personService.getAll();

        System.out.println("qwer");

        return list;
    }

    // 设置访问路由值为路径
    @RequestMapping("/test")
    public String test(){
        System.out.println("qwer");
        return "mav";
    }


}