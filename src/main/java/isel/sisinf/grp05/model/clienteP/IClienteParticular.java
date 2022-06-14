package isel.sisinf.grp05.model.clienteP;

import isel.sisinf.grp05.model.cliente.Cliente;

public interface IClienteParticular {
    Cliente getClienteP();
    void setClienteP(Cliente clienteP);

    Cliente getClienteAssociado();
    void setClienteAssociado(Cliente clienteAssociado);
}


