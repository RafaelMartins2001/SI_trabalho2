package isel.sisinf.grp05.model.alarme;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="Alarme")
@NamedQuery(name="Alarme.findAll", query="SELECT a FROM Alarme a")

public class Alarme implements IAlarme {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="idRegisto")
    private int idRegisto;

    @Column(name="matricula")
    private int matricula;

    public Alarme() {}

    public int getid() {
        return this.id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getidRegisto() {
        return this.idRegisto;
    }

    public void setidRegisto(int idRegisto) {
        this.idRegisto = idRegisto;
    }

    public int getmatricula() {
        return this.matricula;
    }

    public void setmatricula(int matricula) {
        this.matricula = matricula;
    }

}