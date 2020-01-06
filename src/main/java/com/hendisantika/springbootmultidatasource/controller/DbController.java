package com.hendisantika.springbootmultidatasource.controller;

import com.hendisantika.springbootmultidatasource.db1.model.Db1Entity;
import com.hendisantika.springbootmultidatasource.db1.repository.Db1EntityRepository;
import com.hendisantika.springbootmultidatasource.db2.model.Db2Entity;
import com.hendisantika.springbootmultidatasource.db2.repository.Db2EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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

    @GetMapping(value = "/api/db1", produces = MediaType.APPLICATION_JSON_VALUE)
    public Db1Entity testDatabase1(@RequestHeader(required = true, value = HttpHeaders.ACCEPT_LANGUAGE) final String languageCode) {
        return db1EntityRepository.getDb2Entity();
    }

    @GetMapping(value = "/api/db2", produces = MediaType.APPLICATION_JSON_VALUE)
    public Db2Entity testDatabase2(@RequestHeader(required = true, value = HttpHeaders.ACCEPT_LANGUAGE) final String languageCode) {
        return db2EntityRepository.getDb2Entity();
    }

}
