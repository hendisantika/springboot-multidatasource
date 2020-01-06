package com.hendisantika.springbootmultidatasource.db2.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-multidatasource
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/01/20
 * Time: 19.53
 */
@Entity
@Data
public class Db2Entity {

    @Id
    Integer key;

    @Column(name = "database_name")
    String databaseName;

}