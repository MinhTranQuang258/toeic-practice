/*
 * Class: ToeicPracticeDataSource
 *
 * Created on Apr 11, 2018
 *
 * (c) Copyright Swiss Post Solution, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package com.tqminh.vn.toeicpractice.configuration.datasource;

import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.ConnectionPool;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.tqminh.vn.toeicpractice.configuration.datasource.core.AbstractDataSourceConfiguration;

public class ToeicPracticeDataSource extends AbstractDataSourceConfiguration {

    //    @Autowired
    //    private JpaProperties jpaProperties;

    @Override
    public DataSource dataSource() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String[] getPackagesToScan() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected String getPersistenceUnitName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Map<String, Properties> getProperties() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ConnectionPool jmxPool(final DataSource dataSource) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
        // TODO Auto-generated method stub
        return null;
    }
}
