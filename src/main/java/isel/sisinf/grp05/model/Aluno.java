
package isel.sisinf.grp05.model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The persistent class for the alunos database table.
 *
 */
@Entity
@Table(name="alunos")
@NamedQuery(name="Aluno.findAll", query="SELECT a FROM Aluno a")
public class Aluno /*implements Serializable*/ {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="numAl")
    private long numal;

    @Column(name="nomeAl")
    private String nomeal;

    public Aluno() {
    }

    //@Id
    public long getNumal() {
        return this.numal;
    }

    public void setNumal(long numal) {
        this.numal = numal;
    }

    public String getNomeal() {
        return this.nomeal;
    }

    public void setNomeal(String nomeal) {
        this.nomeal = nomeal;
    }

}