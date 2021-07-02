package com.zz.spring_demo1.service;

import com.zz.spring_demo1.model.Person;
import com.zz.spring_demo1.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {
    @Autowired
    PersonDao personDao;

    /*
        Service层介于controller和dao之间作为服务层进行一些逻辑处理，
        这里逻辑太简单所以知识单纯调用dao所以不做注释
     */
    public List<Person> getAll() {
        return personDao.getAll();
    }

    public Person getPersonById(int id) {
        return personDao.getPersonById(id);
    }

    public void delete(int id) {
        personDao.delete(id);
    }

    public void update(Person p) {
        personDao.update(p);
    }

    public void newp(Person p) {
        personDao.newp(p);
    }
}