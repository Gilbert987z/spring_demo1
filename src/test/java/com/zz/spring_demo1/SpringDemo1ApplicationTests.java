package com.zz.spring_demo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDemo1ApplicationTests {


//    @Autowired
//    DataSource dataSource;

    @Test
    void contextLoads() throws Exception{
//        System.out.println("获取的数据库连接为:"+dataSource.getConnection());
    }

}
