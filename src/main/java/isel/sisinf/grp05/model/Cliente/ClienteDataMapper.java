package isel.sisinf.grp05.model.Cliente;

public interface ClienteDataMapper {
    void create(Cliente c);
    Cliente read(Integer id);
    void update(Cliente c);
    void delete(Cliente c);
}
