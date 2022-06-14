package isel.sisinf.grp05.model.veiculo;

import isel.sisinf.grp05.model.cliente.Cliente;
import isel.sisinf.grp05.model.gps.GPS;

public interface IVeiculo {
    String getmatricula();
    void setmatricula(String matricula);

    int gettelCondutor();
    void settelCondutor(int telCondutor);

    String getnomeCondutor();
    void setnomeCondutor(String nomeCondutor);

    GPS getGps();
    void setGps(GPS Gps);

    Cliente getproprieatario();
    void setproprieatario(Cliente proprieatario) ;

    int getnumAlarmes();
    void setnumAlarmes(int numAlarmes);
}