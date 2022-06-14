package isel.sisinf.grp05.model.veiculo;

import java.io.Serializable;
import java.util.Set;

import isel.sisinf.grp05.model.alarme.Alarme;
import isel.sisinf.grp05.model.alarms.Alarms;
import isel.sisinf.grp05.model.cliente.Cliente;
import isel.sisinf.grp05.model.gps.GPS;
import isel.sisinf.grp05.model.grupoZV.GrupoZV;
import jakarta.persistence.*;

@Entity
@Table(name="Veiculo")
@NamedQuery(name="Veiculo.findAll", query="SELECT v FROM Veiculo v")

public class Veiculo implements IVeiculo {

    @Id
    @Column(name="matricula")
    private String matricula;

    @Column(name="telCondutor")
    private int telCondutor;

    @Column(name="nomeCondutor")
    private String nomeCondutor;

    @Column(name="idGps")
    @ManyToOne(cascade=CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name="Gps",referencedColumnName="id")
    private GPS gps;


    @Column(name="proprieatario")
    @ManyToOne(cascade=CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name="proprietario",referencedColumnName="nif")
    private Cliente proprieatario;

    @Column(name="numAlarmes")
    private int numAlarmes;

    @OneToMany(cascade = CascadeType.ALL,mappedBy="matricula",fetch = FetchType.LAZY)
    private Set<GrupoZV> gzvs;

    @OneToMany(cascade = CascadeType.ALL,mappedBy="veiculo",fetch = FetchType.LAZY)
    private Set<Alarme> alarms;

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

    public GPS getGps() {
        return this.gps;
    }

    public void setGps(GPS gps) {
        this.gps = gps;
    }

    public Cliente getproprieatario() {
        return this.proprieatario;
    }

    public void setproprieatario(Cliente proprieatario) {
        this.proprieatario = proprieatario;
    }

    public int getnumAlarmes() {
        return this.numAlarmes;
    }

    public void setnumAlarmes(int numAlarmes) {
        this.numAlarmes = numAlarmes;
    }

}