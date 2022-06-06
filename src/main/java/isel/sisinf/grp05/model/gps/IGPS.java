package isel.sisinf.grp05.model.gps;

import java.util.Date;

public interface IGPS {
    int getId();
    void setId(int id);

    Date getMarcaTemporal();
    void setMarcaTemporal(Date marcaTemporal);

    int getLongitude();
    void setLongitude(int longitude);

    int getLatitude();
    void setLatitude(int latitude);

    String getEstado();
    void setEstado(String estada);
}