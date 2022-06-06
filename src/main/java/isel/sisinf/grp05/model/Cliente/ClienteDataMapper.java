package isel.sisinf.grp05.model.Cliente;

import isel.sisinf.grp05.model.DataMapper;

public interface ClienteDataMapper {
    void create(Cliente c);
    Cliente read(Integer id);
    void update(Cliente c);
    void delete(Cliente c);
}
