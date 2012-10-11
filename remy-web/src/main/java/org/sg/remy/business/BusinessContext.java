package org.sg.remy.business;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.support.SimpleJndiBeanFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@ComponentScan(basePackageClasses = BusinessContext.class)
@EnableTransactionManagement
public class BusinessContext {
	
	public static final String PERSISTENCE_UNIT_NAME = "persistence/RemyPersistenceUnit";
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		return (EntityManagerFactory) new SimpleJndiBeanFactory().getBean(PERSISTENCE_UNIT_NAME);
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JtaTransactionManager();
	}

}
