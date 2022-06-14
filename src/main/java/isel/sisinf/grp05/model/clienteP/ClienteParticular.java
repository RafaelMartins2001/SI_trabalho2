package isel.sisinf.grp05.model.clienteP;

import isel.sisinf.grp05.model.cliente.Cliente;
import jakarta.persistence.*;

@Entity
@Table(name="ClienteParticular")
@NamedQuery(name="ClienteParticular.findAll", query="SELECT c FROM ClienteParticular c")
public class ClienteParticular implements IClienteParticular{
    @Id
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="nif")
    @Column(name = "nif")
    private Cliente clienteP;

    @Column(name="cc")
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="nif")
    private Cliente clienteAssociado;

    public ClienteParticular() {}

    public Cliente getClienteP() {
        return this.clienteP;
    }

    public void setClienteP(Cliente clienteP) {
        this.clienteP = clienteP;
    }

    public Cliente getClienteAssociado() {
        return this.clienteAssociado;
    }

    public void setClienteAssociado(Cliente clienteAssociado) {
        this.clienteAssociado = clienteAssociado;
    }

}


