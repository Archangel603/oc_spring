package com.boomcup.server.config

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
class DataSourceConfig
{
    /*@Bean
    fun dataSource(): DataSource? {

        val dataSource = DriverManagerDataSource()

        dataSource.apply {
            setDriverClassName("com.mysql.cj.jdbc.Driver")
            username = "archangel"
            password = "0cb4d9defa4acba3f6c1d77f59fc7d2f"
            url = "jdbc:mysql://localhost:3306/myDb?createDatabaseIfNotExist=true"

        }

        return dataSource
    }*/

}