package sample.jetty.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name = "StanProcesow.findByIdIngnoringCase", query = "SELECT sp FROM sample.jetty.domain.StanProcesow sp WHERE LOWER(sp.id) = LOWER(?1)")
@Table(name = "stan_procesow", schema = "adm")
public class StanProcesow implements Serializable {

    private String proces;
    private Integer liczbaOdwolan;

    @Id
    @Column(name = "proces", unique = true, nullable = false, length = 60)
    public String getId() {
        return this.proces;
    }
    public void setId(String id) {
        this.proces = id;
    }

    @Column(name = "liczba_odwolan")
    public Integer getLiczbaOdwolan() {
        return this.liczbaOdwolan;
    }

    public void setLiczbaOdwolan(Integer liczbaOdwolan) {
        this.liczbaOdwolan = liczbaOdwolan;
    }

    @Override
    public String toString() {
        return "StanProcesow{" +
                "proces='" + proces + '\'' +
                ", liczbaOdwolan=" + liczbaOdwolan +
                '}';
    }
}
