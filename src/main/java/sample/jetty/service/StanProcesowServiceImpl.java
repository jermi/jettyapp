package sample.jetty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import sample.jetty.domain.StanProcesow;
import sample.jetty.service.utils.HibernateConfig;

import javax.persistence.EntityManagerFactory;
import java.util.Iterator;


/**
 * Created by mik on 08.12.14.
 */
@Validated
@Component
@Transactional
public class StanProcesowServiceImpl implements StanProcesowService {

    private final StanProcesowRepository stanProcesowRepository;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private HibernateConfig hibernateConfig;

    @Autowired
    public StanProcesowServiceImpl(StanProcesowRepository stanProcesowRepository) {
        this.stanProcesowRepository = stanProcesowRepository;
    }

    @Override
    public Page<StanProcesow> findStanProcesow(StanProcesowSearchCriteria criteria, Pageable pageable) {
        Assert.notNull(criteria, "Criteria must not be null");
        System.out.println("Hibernate entity manager factory do niestandardowych działań 1: " + entityManagerFactory);
        //java.lang.ClassCastException: org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean$$EnhancerBySpringCGLIB$$e43527ca cannot be cast to javax.persistence.EntityManagerFactory
        //System.out.println("Hibernate entity manager factory do niestandardowych działań 2: " + hibernateConfig.entityManagerFactory());
        System.out.println("Hibernate session factory do niestandardowych działań 1: " + hibernateConfig.sessionFactory(entityManagerFactory));
        System.out.println("Hibernate session factory do niestandardowych działań 2: " + hibernateConfig.sessionFactory());
        Page<StanProcesow> ret = null;
        if (StringUtils.isEmpty(criteria.getId())){
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ALL");
            ret = stanProcesowRepository.findAll(pageable);
        }
        else {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!BY");
            ret = stanProcesowRepository.findByIdIngnoringCase(criteria.getId(), pageable);
        }
        System.out.println("Found " + ret.getTotalElements() + ", " + ret.getTotalPages() + ", " + ret.getNumber() + ", " + ret.getNumberOfElements());
        Iterator<StanProcesow> it = ret.iterator();
        while (it.hasNext()){
            StanProcesow sp = it.next();
            System.out.println(sp);
        }
        System.out.println("==================================");
        return ret;
    }
}
