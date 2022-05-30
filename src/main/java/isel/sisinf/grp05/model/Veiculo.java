package isel.sisinf.grp05.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="Veiculo")
@NamedQuery(name="Veiculo.findAll", query="SELECT v FROM Veiculo v")

public class Veiculo {

    @Id
    @Column(name="matricula")
    private String matricula;

    @Column(name="telCondutor")
    private int telCondutor;

    @Column(name="nomeCondutor")
    private String nomeCondutor;

    @Column(name="idGps")
    private int idGps;

    @Column(name="proprieatario")
    private int proprieatario;

    @Column(name="numAlarmes")
    private int numAlarmes;

    public Veiculo() {}

    public String getmatricula() {
        return this.matricula;
    }

    public void setmatricula(String matricula) {
        this.matricula = matricula;
    }

    public int gettelCondutor() {
        return this.telCondutor;
    }

    public void settelCondutor(int telCondutor) {
        this.telCondutor = telCondutor;
    }

    public String getnomeCondutor() {
        return this.nomeCondutor;
    }

    public void setnomeCondutor(String nomeCondutor) {
        this.nomeCondutor = nomeCondutor;
    }

    public int getidGps() {
        return this.idGps;
    }

    public void setidGps(int idGps) {
        this.idGps = idGps;
    }

    public int getproprieatario() {
        return this.proprieatario;
    }

    public void setproprieatario(int proprieatario) {
        this.proprieatario = proprieatario;
    }

    public int getnumAlarmes() {
        return this.numAlarmes;
    }

    public void setnumAlarmes(int numAlarmes) {
        this.numAlarmes = numAlarmes;
    }

}