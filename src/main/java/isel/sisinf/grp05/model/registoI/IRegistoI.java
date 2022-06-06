package isel.sisinf.grp05.model.registoI;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="RegistoI")
@NamedQuery(name="RegistoI.findAll", query="SELECT r FROM RegistoI r")

public class IRegistoI {

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

    public IRegistoI() {}

    public int getid() {
        return this.id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public Date getdata() {
        return this.data;
    }

    public void setdata(Date data) {
        this.data = data;
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

    public int getidGps() {
        return this.idGps;
    }

    public void setidGps(int idGps) {
        this.idGps = idGps;
    }

}