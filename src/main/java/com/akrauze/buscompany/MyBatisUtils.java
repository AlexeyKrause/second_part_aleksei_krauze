package com.akrauze.buscompany;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.Reader;

@Slf4j
@Configuration
public class MyBatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    public static boolean initSqlSessionFactory() {
        try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            
// 		instead of setting here, it is possible to set in configuration XML file
//      sqlSessionFactory.getConfiguration().setAggressiveLazyLoading(false);

            return true;
        } catch (Exception e) {
            log.error("Error loading mybatis-config.xml", e);
            return false;
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}