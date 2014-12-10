package sample.jetty.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sample.jetty.domain.StanProcesow;

/**
 * Created by mik on 08.12.14.
 */
public interface StanProcesowService {

    Page<StanProcesow> findStanProcesow(StanProcesowSearchCriteria criteria, Pageable pageable);
}
