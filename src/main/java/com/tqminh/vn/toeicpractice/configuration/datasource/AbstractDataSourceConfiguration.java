package com.tqminh.vn.toeicpractice.configuration.datasource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.ConnectionPool;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

public abstract class AbstractDataSourceConfiguration {
	
	public abstract ConnectionPool jmxPool(DataSource dataSource);
	
	public abstract DataSource dataSource();
	
	protected LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean= new LocalContainerEntityManagerFactoryBean();
		
		localContainerEntityManagerFactoryBean.setPackagesToScan(this.getPackagesToScan());
		final HibernateJpaVendorAdapter hibernateJpaVendorAdapter= new HibernateJpaVendorAdapter();
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		localContainerEntityManagerFactoryBean.setPersistenceUnitName(this.getPersistenceUnitName());
		return localContainerEntityManagerFactoryBean;
	
	}
	
	public abstract PlatformTransactionManager platformTransactionManager(EntityManagerFactory entityManagerFactory);
	
	protected abstract String[] getPackagesToScan();
	
	protected abstract String getPersistenceUnitName();
}
