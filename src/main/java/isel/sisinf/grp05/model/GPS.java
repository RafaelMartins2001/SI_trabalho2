package isel.sisinf.grp05.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="GPS")
@NamedQuery(name="GPS.findAll", query="SELECT g FROM GPS g")

public class GPS {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="marcaTemporal")
    private Date marcaTemporal;

    @Column(name="longitude")
    private int longitude;

    @Column(name="latitude")
    private int latitude;

    @Column(name="estada")
    private String estada;

    public GPS() {}

    public int getid() {
        return this.id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public Date getmarcaTemporal() {
        return this.marcaTemporal;
    }

    public void setmarcaTemporal(Date marcaTemporal) {
        this.marcaTemporal = marcaTemporal;
    }

    public int getlongitude() {
        return this.longitude;
    }

    public void setlongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getlatitude() {
        return this.latitude;
    }

    public void setlatitude(int latitude) {
        this.latitude = latitude;
    }

    public String getestada() {
        return this.estada;
    }

    public void setestada(String estada) {
        this.estada = estada;
    }

}