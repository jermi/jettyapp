package sample.jetty.service;

import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * Created by mik on 08.12.14.
 */
public class StanProcesowSearchCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    public StanProcesowSearchCriteria() {
    }

    public StanProcesowSearchCriteria(String id) {
//        Assert.notNull(name, "Id must not be null");
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
