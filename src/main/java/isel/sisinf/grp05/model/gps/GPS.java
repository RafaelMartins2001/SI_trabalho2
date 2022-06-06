package isel.sisinf.grp05.model.gps;

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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getMarcaTemporal() {
        return this.marcaTemporal;
    }

    public void setMarcaTemporal(Date marcaTemporal) {
        this.marcaTemporal = marcaTemporal;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public String getEstado() {
        return this.estada;
    }

    public void setEstado(String estada) {
        this.estada = estada;
    }

}