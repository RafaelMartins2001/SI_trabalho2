package isel.sisinf.grp05.model.zv;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="ZV")
@NamedQuery(name="ZV.findAll", query="SELECT z FROM ZV z")

public class ZV implements IZV {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="longitude")
    private int longitude;

    @Column(name="latitude")
    private int latitude;

    @Column(name="raio")
    private int raio;


    @ManyToMany
    @JoinTable(name="GrupoZV",
            joinColumns=@JoinColumn(name="id"),
            inverseJoinColumns=@JoinColumn(name="id"))
    private Set<ZV> gruposZVs;

    public ZV() {}

    public int getid() {
        return this.id;
    }

    public void setid(int id) {
        this.id = id;
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

    public int getraio() {
        return this.raio;
    }

    public void setraio(int raio) {
        this.raio = raio;
    }

}