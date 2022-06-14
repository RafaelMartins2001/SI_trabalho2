package isel.sisinf.grp05.model.registoI;

import isel.sisinf.grp05.model.gps.GPS;

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

    GPS getGps();
    void setGps(GPS Gps);
}