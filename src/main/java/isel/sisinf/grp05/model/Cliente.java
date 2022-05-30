package isel.sisinf.grp05.model;

import java.io.Serializable;
import jakarta.persistence.*;
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")

public class Cliente {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="nif")
    private int nif;

    @Column(name="nome")
    private String nome;

    @Column(name="morada")
    private String morada;

    @Column(name="telefone")
    private int telefone;

    @Column(name="referencia")
    private int referencia;

    @Column(name="estado")
    private String estado;

    public Cliente() {
    }


    //@Id
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

    public void setReferencia(int referencia){
        this.referencia = referencia;
    }

    public String getEstado(){
        return this.estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

}
