package isel.sisinf.grp05.model.registoI;

import java.util.Date;

public interface IRegistoI {
    int getId();
    void setId(int id);

    Date getData();
    void setData(Date data);

    int getLongitude();
    void setLongitude(int longitude);

    int getLatitude();
    void setLatitude(int latitude);

    int getIdGps();

    void setIdGps(int idGps);
}