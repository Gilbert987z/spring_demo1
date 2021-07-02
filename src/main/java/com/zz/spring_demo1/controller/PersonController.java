package com.zz.spring_demo1.controller;

import com.zz.spring_demo1.model.Person;
import com.zz.spring_demo1.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Api(description = "商户平台应用接口")
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
    @RequestMapping("/personbyid/{id}")
    public Person personbyid(@PathVariable int id){
        // 顾名思义 实体和数据 同时返回页面模板和数据
        return personService.getPersonById(id);
    }

    @GetMapping("/persondel/{id}")
    public String del(@PathVariable int id){
        personService.delete(id);
        return "yes";
    }

    @ApiOperation( value = "测试swagger其他常用注解",httpMethod = "POST")
    @ApiImplicitParam(name = "id", value = "商户id", dataType = "Long", paramType ="query", required = true)
    // 设置访问路由值为路径
    @RequestMapping(value = "/personlistbypage",method = RequestMethod.GET,consumes="application/json" )
    public List<Person> personlist(@RequestParam(name = "page") String page,@RequestParam(name = "size") String size){
        // 顾名思义 实体和数据 同时返回页面模板和数据
        System.out.println("page:"+page+",size:"+size);
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