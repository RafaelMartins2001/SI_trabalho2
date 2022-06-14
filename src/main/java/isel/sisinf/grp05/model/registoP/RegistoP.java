package isel.sisinf.grp05.model.registoP;

import isel.sisinf.grp05.model.gps.GPS;
import isel.sisinf.grp05.model.registoP.IRegistoP;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="RegistoP")
@NamedQuery(name="RegistoP.findAll", query="SELECT r FROM RegistoP r")

public class RegistoP implements IRegistoP {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="data")
    private Date data;

    @Column(name="longitude")
    private int longitude;

    @Column(name="latitude")
    private int latitude;

    @ManyToOne(cascade=CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name="Gps",referencedColumnName="id")
    private GPS gps;

    public RegistoP() {}

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

    public GPS getGps() {
        return this.gps;
    }

    public void setGps(GPS gps) {
        this.gps = gps;
    }

}