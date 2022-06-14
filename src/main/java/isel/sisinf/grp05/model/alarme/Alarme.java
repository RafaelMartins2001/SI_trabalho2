package isel.sisinf.grp05.model.alarme;

import java.io.Serializable;

import isel.sisinf.grp05.model.cliente.Cliente;
import isel.sisinf.grp05.model.registoP.RegistoP;
import isel.sisinf.grp05.model.veiculo.Veiculo;
import jakarta.persistence.*;

@Entity
@Table(name="Alarme")
@NamedQuery(name="Alarme.findAll", query="SELECT a FROM Alarme a")

public class Alarme implements IAlarme {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="registoP")
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="idRegisto")
    private RegistoP registoP;

    @Column(name="veiculo")
    @ManyToOne(cascade=CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name="Veiculo",referencedColumnName="matricula")
    private Veiculo veiculo;

    public Alarme() {}

    public int getid() {
        return this.id;
    }

    public void setid(int id) {
        this.id = id;
    }


    public RegistoP getRegisto() {
        return this.registoP;
    }

    public void setRegisto(RegistoP registoP) {
        this.registoP = registoP;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

}