package com.example.demo.config;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class MyJpaGenerator implements IdentifierGenerator {


    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return getId();
    }

    @Override
    public boolean supportsJdbcBatchInserts() {
        return false;
    }

    public static long getId(){
        return System.currentTimeMillis();
    }
}
