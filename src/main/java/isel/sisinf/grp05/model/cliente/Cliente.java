package isel.sisinf.grp05.model.cliente;

import isel.sisinf.grp05.model.veiculo.Veiculo;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")

public class Cliente implements ICliente {
    private static final Integer DEFAULT_REFERENCE = null;
    private static final String DEFAULT_STATE = "Activo";

    @Id
    @Column(name="nif")
    private int nif;

    @Column(name="nome")
    private String nome;

    @Column(name="morada")
    private String morada;

    @Column(name="telefone")
    private int telefone;

    @ManyToOne(targetEntity = Cliente.class)
    private Integer referencia;

    @Column(name="estado")
    private String estado;

    @OneToMany(cascade = CascadeType.ALL,mappedBy="proprietario",fetch = FetchType.LAZY)
    private Set<Veiculo> veiculos;


    public Cliente(){}

    public int getNif() {
        return this.nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada(){
        return this.morada;
    }

    public void setMorada(String morada){
        this.morada = morada;
    }

    public int getTelefone(){
        return this.telefone;
    }

    public void setTelefone(int telefone){
        this.telefone = telefone;
    }

    public int getReferencia(){
        return this.referencia;
    }

    public void setReferencia(Integer referencia){
        this.referencia = referencia;
    }

    public void setReferencia() {this.referencia = DEFAULT_REFERENCE;}

    public String getEstado(){
        return this.estado;
    }

    public void setEstado(String estado){ this.estado = estado; }

    public void setEstado() {this.estado = DEFAULT_STATE;}
}
