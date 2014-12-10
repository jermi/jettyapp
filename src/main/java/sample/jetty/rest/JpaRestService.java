package sample.jetty.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import sample.jetty.domain.StanProcesow;
import sample.jetty.domain.utils.PageableImpl;
import sample.jetty.service.GreetingsService;
import sample.jetty.service.StanProcesowSearchCriteria;
import sample.jetty.service.StanProcesowService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by kkoziel on 2014-11-24.
 */
@Path("")
@Component
@Produces(MediaType.APPLICATION_JSON)
public class JpaRestService {

    @Autowired
    private StanProcesowService stanProcesowService;

    @Path("/jpaQueryParam")
    @GET
    @Transactional(readOnly = true)
    public Page<StanProcesow> jpaQueryParam(@QueryParam("procesId") String procesId) {
        StanProcesowSearchCriteria criteria = new StanProcesowSearchCriteria();
        if (!StringUtils.isEmpty(procesId)){
            criteria.setId(procesId);
        }
        return this.stanProcesowService.findStanProcesow(criteria, new PageableImpl());
    }

    @Path("/pojo")
    @GET
    @Transactional(readOnly = true)
    public Boolean pojo() {
        return true;
    }

    @Path("/jpaPathParam/{procesId}")
    @GET
    @Transactional(readOnly = true)
    public Page<StanProcesow> jpaPathParam(@PathParam("procesId") String procesId) {
        StanProcesowSearchCriteria criteria = new StanProcesowSearchCriteria();
        return this.stanProcesowService.findStanProcesow(criteria, new PageableImpl());
    }


}
