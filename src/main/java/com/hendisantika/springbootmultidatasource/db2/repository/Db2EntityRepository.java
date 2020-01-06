package com.hendisantika.springbootmultidatasource.db2.repository;

import com.hendisantika.springbootmultidatasource.db2.model.Db2Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-multidatasource
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/01/20
 * Time: 19.54
 */
public interface Db2EntityRepository extends JpaRepository<Db2Entity, Long> {

    @Query(value = "SELECT 2 AS key, current_database() AS database_name ", nativeQuery = true)
    Db2Entity getDb2Entity();

}