package com.hendisantika.springbootmultidatasource.db1.repository;

import com.hendisantika.springbootmultidatasource.db1.model.Db1Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-multidatasource
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/01/20
 * Time: 19.52
 */
public interface Db1EntityRepository extends JpaRepository<Db1Entity, Long> {

    @Query(value = "SELECT 1 AS key, current_database() AS database_name ", nativeQuery = true)
    Db1Entity getDb2Entity();

}