package isel.sisinf.grp05.model.grupoZV;

import java.util.Set;

import isel.sisinf.grp05.model.veiculo.Veiculo;
import isel.sisinf.grp05.model.zv.ZV;
import jakarta.persistence.*;

@Entity
@Table(name="GrupoZV")
@NamedQuery(name="GrupoZV.findAll", query="SELECT g FROM GrupoZV g")
public class GrupoZV implements IGrupoZV {
    @Id
    @Column(name="id")
    private int id;

    @ManyToOne(cascade=CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name="zv",referencedColumnName="id")
    private ZV zv;


    @ManyToOne(cascade=CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name="veiculo",referencedColumnName="matricula")
    private Veiculo veiculo;

    public GrupoZV() {}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ZV getZVs() {
        return this.zv;
    }

    public void setZV(ZV zv) {
        this.zv = zv;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}