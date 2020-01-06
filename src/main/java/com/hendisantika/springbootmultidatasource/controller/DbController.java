package com.hendisantika.springbootmultidatasource.controller;

import com.hendisantika.springbootmultidatasource.db1.repository.Db1EntityRepository;
import com.hendisantika.springbootmultidatasource.db2.repository.Db2EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-multidatasource
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/01/20
 * Time: 20.00
 */
@RestController
public class DbController {

    @Autowired
    Db1EntityRepository db1EntityRepository;

    @Autowired
    Db2EntityRepository db2EntityRepository;

}
