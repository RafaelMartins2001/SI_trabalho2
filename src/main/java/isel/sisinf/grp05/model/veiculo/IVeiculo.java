package isel.sisinf.grp05.model.veiculo;

public interface IVeiculo {
    String getmatricula();
    void setmatricula(String matricula);

    int gettelCondutor();
    void settelCondutor(int telCondutor);

    String getnomeCondutor();
    void setnomeCondutor(String nomeCondutor);

    int getidGps();
    void setidGps(int idGps);

    int getproprieatario();
    void setproprieatario(int proprieatario) ;

    int getnumAlarmes();
    void setnumAlarmes(int numAlarmes);
}