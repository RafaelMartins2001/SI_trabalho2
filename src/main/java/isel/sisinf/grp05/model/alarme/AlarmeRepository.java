package isel.sisinf.grp05.model.alarme;

import isel.sisinf.grp05.model.cliente.Cliente;
import isel.sisinf.grp05.repo.IRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.Collection;
import java.util.List;


public class AlarmeRepository implements IRepository<Cliente, Collection<Cliente>, Integer> {
    private final EntityManager _em;
    //private final Mapper mapper;

    public AlarmeRepository(EntityManager em) {
        this._em = em;
        //this.mapper = ;
    }

    @Override
    public List<Cliente> findAll() throws Exception {
        return _em.createNamedQuery("Cliente.getAll", Cliente.class)
                .getResultList();
    }

    @Override
    public Cliente create(Cliente entity) {
        _em.persist(entity);
        return entity;
    }

    @Override
    public Cliente read(Integer id) {
        return null;
    }

    @Override
    public Cliente update(Cliente entity) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        try {
            _em.getTransaction().begin();
            Query query = _em.createNativeQuery("delete from cliente_institucional where nif = (?1)");
            query.setParameter(1, id);
            query.executeUpdate();
            _em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            _em.close();
        }
        return null;
    }
}
