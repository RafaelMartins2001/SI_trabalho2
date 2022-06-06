package isel.sisinf.grp05.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
    @Table(name="Alarms")
    @NamedQuery(name="Alarms.findAll", query="SELECT a FROM Alarme a")

    public class Alarms {

        @Id
        @Column(name="matricula")
        private String matricula;

        @Column(name="nomeCondutor")
        private String nomeCondutor;

        @Column(name="latitude")
        private int latitude;

        @Column(name="longitude")
        private int longitude;

        @Column(name="data")
        private Date data;

        public Alarms() {}

        public String getMatricula() {
            return this.matricula;
        }

        public void setMatricula(int id) {
            this.matricula = matricula;
        }

        public String getNomeCondutor() {
            return this.nomeCondutor;
        }

        public void setNomeCondutor(String nomeCondutor) {
            this.nomeCondutor = nomeCondutor;
        }

        public int getLatitude() {return this.latitude;}

        public void setLatitude(int latitude) {
            this.latitude = latitude;
        }

        public int getLongitude() {
            return this.longitude;
        }

        public void setLongitude(int longitude) {this.longitude = longitude;}

        public Date getData() {
            return this.data;
        }

        public void setData(Date data) {
            this.data = data;
        }
    }
