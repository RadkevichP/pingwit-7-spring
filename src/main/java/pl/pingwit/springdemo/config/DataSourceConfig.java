package pl.pingwit.springdemo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

  /*  @Value("${pingwit.datasource.url}")
    private String url;

    @Value("${pingwit.datasource.username}")
    private String username;

    @Value("${pingwit.datasource.password}")
    private String password;*/

 /*   @Bean
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();

        ds.setJdbcUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }*/
}
