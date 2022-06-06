package isel.sisinf.grp05.model.cliente;

public interface ICliente {
    int getNif();

    void setNif(int nif);

    String getNome();

    void setNome(String nome);

    String getMorada();

    void setMorada(String morada);

    int getTelefone();

    void setTelefone(int telefone);

    int getReferencia();

    void setReferencia(Integer referencia);

    String getEstado();

    void setEstado(String estado);
}
