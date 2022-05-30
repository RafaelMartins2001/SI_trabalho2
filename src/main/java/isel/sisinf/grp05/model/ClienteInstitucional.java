package isel.sisinf.grp05.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="ClienteInstitucional")
@NamedQuery(name="ClienteInstitucional.findAll", query="SELECT c FROM ClienteInstitucional c")

public class ClienteInstitucional {

    @Id
    @Column(name = "nif")
    private int nif;

    @Id
    @Column(name = "nomeContrato")
    private String nomeContrato;

    public ClienteInstitucional() {
    }

    public int getnif() {
        return this.nif;
    }

    public void setnif(int nif) {
        this.nif = nif;
    }

    public String getnomeContrato() {
        return this.nomeContrato;
    }

    public void setnomeContrato(String nomeContrato) {
        this.nomeContrato = nomeContrato;
    }

}