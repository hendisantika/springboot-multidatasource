package com.hendisantika.springbootmultidatasource.db1.model;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-multidatasource
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/01/20
 * Time: 19.51
 */
@Entity
@Data
public class Db1Entity {
    @Id
    Integer key;

    @Column(name = "database_name")
    String databaseName;

}
