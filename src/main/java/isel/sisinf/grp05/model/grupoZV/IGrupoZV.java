package isel.sisinf.grp05.model.grupoZV;

import isel.sisinf.grp05.model.veiculo.Veiculo;
import isel.sisinf.grp05.model.zv.ZV;

import java.util.Set;

public interface IGrupoZV {
    int getId();
    void setId(int id);

    ZV getZVs();
    void setZV(ZV zv);

    Veiculo getVeiculo();
    void setVeiculo(Veiculo veiculo);
}