package isel.sisinf.grp05.model.alarms;

import java.util.Date;

public interface IAlarms {

        String getMatricula();

        void setMatricula(int id);

        String getNomeCondutor();

        void setNomeCondutor(String nomeCondutor);

        int getLatitude();

        void setLatitude(int latitude);

        int getLongitude();

        void setLongitude(int longitude);

        Date getData();

        void setData(Date data);
    }
