package kp.exercise.app.wiring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;

import javax.sql.DataSource;

@EnableAspectJAutoProxy
@Configuration
public class AppConfig {
	
	private static Logger LOG = LoggerFactory.getLogger(AppConfig.class);
	
	@Autowired
	MeterRegistry meterRegistry;
	
    @Bean
    @ConfigurationProperties(prefix = "app.datasource-pg")
    DataSource pgDataSource() {
		DataSource dataSource = DataSourceBuilder.create().driverClassName("org.postgresql.Driver").build();
		LOG.debug("pg datasource was created");
        return dataSource;
    }
    
    @Bean
    public NamedParameterJdbcTemplate pgNamedJdbcTemplate() {
    	return new NamedParameterJdbcTemplate(pgDataSource());
    }
    
    @Bean
    public JdbcTemplate pgJdbcTemplate() {
    	return new JdbcTemplate(pgDataSource());
    }
    
    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
    	return new TimedAspect(registry);
    }
    
}