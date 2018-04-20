package com.tqminh.vn.toeicpractice.configuration.datasource.core;

import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.ConnectionPool;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

public abstract class AbstractDataSourceConfiguration {

    public abstract DataSource dataSource();

    protected LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean(
        final DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        localContainerEntityManagerFactoryBean
            .setPackagesToScan(this.getPackagesToScan());
        final HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        localContainerEntityManagerFactoryBean
            .setJpaVendorAdapter(hibernateJpaVendorAdapter);
        localContainerEntityManagerFactoryBean
            .setPersistenceUnitName(this.getPersistenceUnitName());
        localContainerEntityManagerFactoryBean
            .setJpaPropertyMap(this.getProperties());
        return localContainerEntityManagerFactoryBean;
    }

    protected abstract String[] getPackagesToScan();

    protected abstract String getPersistenceUnitName();

    protected abstract Map<String, Properties> getProperties();

    public abstract ConnectionPool jmxPool(DataSource dataSource);

    protected abstract LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean();

    protected PlatformTransactionManager platformTransactionManager(
        final EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
