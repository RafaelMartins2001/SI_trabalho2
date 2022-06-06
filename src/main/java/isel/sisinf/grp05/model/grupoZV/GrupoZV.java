package isel.sisinf.grp05.model.grupoZV;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="GrupoZV")
@NamedQuery(name="GrupoZV.findAll", query="SELECT g FROM GrupoZV g")
public class GrupoZV implements IGrupoZV {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="zv")
    private int zv;

    @Column(name="matricula")
    private String matricula;

    public GrupoZV() {}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getZV() {
        return this.zv;
    }

    public void setZV(int zv) {
        this.zv = zv;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}