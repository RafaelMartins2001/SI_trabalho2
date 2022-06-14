package isel.sisinf.grp05.model.ClienteI;

import isel.sisinf.grp05.model.cliente.Cliente;

public interface IClienteInstitucional {

    Cliente getCliente();

    void setCliente(Cliente cliente);

    String getnomeContrato();

    void setnomeContrato(String nomeContrato);

}