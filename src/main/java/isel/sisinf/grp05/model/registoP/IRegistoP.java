package isel.sisinf.grp05.model.registoP;

import isel.sisinf.grp05.model.gps.GPS;

import java.util.Date;

public interface IRegistoP {
     int getid();
     void setid(int id);

     Date getdata();
     void setdata(Date data);

     int getlongitude();
     void setlongitude(int longitude);

     int getlatitude();
     void setlatitude(int latitude);

     GPS getGps();
     void setGps(GPS Gps);
}