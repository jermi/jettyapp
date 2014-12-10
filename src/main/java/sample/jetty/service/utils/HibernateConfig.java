package sample.jetty.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import javax.persistence.EntityManagerFactory;

/**
 * Created by mik on 09.12.14.
 */
@Configuration
public class HibernateConfig {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
        HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
        factory.setEntityManagerFactory(emf);
        return factory;
    }

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return sessionFactory(entityManagerFactory);
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(){
        return entityManagerFactory;
    }
}