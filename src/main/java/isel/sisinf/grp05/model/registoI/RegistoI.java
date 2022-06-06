package isel.sisinf.grp05.model.registoI;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="RegistoI")
@NamedQuery(name="RegistoI.findAll", query="SELECT r FROM RegistoI r")

public class RegistoI implements IRegistoI{
    @Id
    @Column(name="id")
    private int id;

    @Column(name="data")
    private Date data;

    @Column(name="longitude")
    private int longitude;

    @Column(name="latitude")
    private int latitude;

    @Column(name="idGps")
    private int idGps;

    public RegistoI() {}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public int getIdGps() {
        return this.idGps;
    }

    public void setIdGps(int idGps) {
        this.idGps = idGps;
    }

}