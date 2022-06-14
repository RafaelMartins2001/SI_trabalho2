package isel.sisinf.grp05.model.alarme;

import isel.sisinf.grp05.model.registoP.RegistoP;
import isel.sisinf.grp05.model.veiculo.Veiculo;

public interface IAlarme {

    int getid();

    void setid(int id);

    RegistoP getRegisto();

    void setRegisto(RegistoP registoP);

    Veiculo getVeiculo();

    void setVeiculo(Veiculo veiculo);

}