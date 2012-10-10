package org.sg.remy.business;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.support.SimpleJndiBeanFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@ComponentScan(basePackageClasses = BusinessContext.class)
@EnableTransactionManagement()
//@Import({ JndiInfrastructureConfig.class, StandaloneInfrastructureConfig.class })
public class BusinessContext {
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		return (EntityManagerFactory) new SimpleJndiBeanFactory().getBean("persistence/RemyPersistenceUnit");
	}

	@Bean
	public JtaTransactionManager transactionManager() {
		return new JtaTransactionManager();
	}

}
