package isel.sisinf.grp05.model.ClienteI;

import java.io.Serializable;

import isel.sisinf.grp05.model.cliente.Cliente;
import jakarta.persistence.*;

@Entity
@Table(name="ClienteInstitucional")
@NamedQuery(name="ClienteInstitucional.findAll", query="SELECT c FROM ClienteInstitucional c")

public class ClienteInstitucional implements IClienteInstitucional{

    @Id
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="nif")
    @Column(name = "nif")
    private Cliente cliente;

    @Id
    @Column(name = "nomeContrato")
    private String nomeContrato;

    public ClienteInstitucional() {
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getnomeContrato() {
        return this.nomeContrato;
    }

    public void setnomeContrato(String nomeContrato) {
        this.nomeContrato = nomeContrato;
    }

}