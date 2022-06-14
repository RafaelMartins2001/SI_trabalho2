package isel.sisinf.grp05.model.registoI;

import java.util.Date;

import isel.sisinf.grp05.model.gps.GPS;
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

    @Column(name="gps")
    @ManyToOne(cascade=CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name="Gps",referencedColumnName="id")
    private GPS gps;

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

    public GPS getGps() {
        return this.gps;
    }

    public void setGps(GPS gps) {
        this.gps = gps;
    }

}