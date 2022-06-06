package isel.sisinf.grp05.model.clienteP;

import jakarta.persistence.*;

@Entity
@Table(name="ClienteParticular")
@NamedQuery(name="ClienteParticular.findAll", query="SELECT c FROM ClienteParticular c")
public class ClienteParticular {
    @Id
    @Column(name="nif")
    private int nif;


    @Column(name="cc")
    private int cc;

    public ClienteParticular() {}

    public int getNif() {
        return this.nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getCC() {
        return this.cc;
    }

    public void setCC(int cc) {
        this.cc = cc;
    }

}


