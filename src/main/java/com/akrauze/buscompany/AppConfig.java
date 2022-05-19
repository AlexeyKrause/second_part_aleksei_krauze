package com.akrauze.buscompany;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.akrauze.buscompany")
@Configuration
public class AppConfig {

    //    @Bean
    //    public DataSource dataSource() {
    //        return new EmbeddedDatabaseBuilder()
    //          .setType(EmbeddedDatabaseType.H2)
    //          .addScript("schema.sql")
    //          .addScript("data.sql")
    //          .build();
    //    }
    //
    //    @Bean
    //    public SqlSessionFactory sqlSessionFactory() throws Exception {
    //        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    //        factoryBean.setDataSource(dataSource());
    //        return factoryBean.getObject();
    //    }
    //}
}
