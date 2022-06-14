package isel.sisinf.grp05.model.grupoZV;

import java.io.Serializable;
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

    @Column(name="zv")
    @ManyToMany
    @JoinTable(name="ZV",
            joinColumns=@JoinColumn(name="id"),
            inverseJoinColumns=@JoinColumn(name="id"))
    private Set<ZV> zvs;


    @Column(name="matricula")
    @ManyToMany
    @JoinTable(name="Veiculo",
            joinColumns=@JoinColumn(name="matricula"),
            inverseJoinColumns=@JoinColumn(name="matricula"))
    private Set<Veiculo> veiculos;

    public GrupoZV() {}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<ZV> getZVs() {
        return this.zvs;
    }

    public void setZV(ZV zv) {
        this.zvs.add(zv);
    }

    public Set<Veiculo> getVeiculos() {
        return this.veiculos;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }
}