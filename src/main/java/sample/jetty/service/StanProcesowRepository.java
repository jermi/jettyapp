package sample.jetty.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import sample.jetty.domain.StanProcesow;

/**
 * Created by mik on 08.12.14.
 */
interface StanProcesowRepository extends Repository<StanProcesow, String> {

    @Query("select sp from sample.jetty.domain.StanProcesow sp")
    Page<StanProcesow> findAll(Pageable pageable);

    Page<StanProcesow> findByIdIngnoringCase(String id, Pageable pageable);

}
