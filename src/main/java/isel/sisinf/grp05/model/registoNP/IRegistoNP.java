package isel.sisinf.grp05.model.registoNP;

import jakarta.persistence.*;

import java.util.Date;

public interface IRegistoNP {
    int getid();
    void setid(int id);

    Date getdata();
    void setdata(Date data);

    int getlongitude();
    void setlongitude(int longitude);

    int getlatitude();
    void setlatitude(int latitude);

    int getidGps();
    void setidGps(int idGps);
}
