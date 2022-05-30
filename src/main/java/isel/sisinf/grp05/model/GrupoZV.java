package isel.sisinf.grp05.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="GrupoZV")
@NamedQuery(name="GrupoZV.findAll", query="SELECT g FROM GrupoZV g")

public class GrupoZV {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="zv")
    private int zv;

    @Column(name="matricula")
    private String matricula;

    public GrupoZV() {}

    public int getid() {
        return this.id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getzv() {
        return this.zv;
    }

    public void setzv(int zv) {
        this.zv = zv;
    }

    public String getmatricula() {
        return this.matricula;
    }

    public void setmatricula(String matricula) {
        this.matricula = matricula;
    }

}