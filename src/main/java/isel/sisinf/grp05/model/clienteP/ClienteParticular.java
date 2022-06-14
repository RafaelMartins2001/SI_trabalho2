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
    private Cliente clienteP;

    @Column(name = "cc")
    private Integer cc;

    public ClienteParticular() {}

    public Cliente getClienteP() {
        return this.clienteP;
    }

    public void setClienteP(Cliente clienteP) {
        this.clienteP = clienteP;
    }

    public Integer getCc() {
        return this.cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

}


