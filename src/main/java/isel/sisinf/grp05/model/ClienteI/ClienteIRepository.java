package isel.sisinf.grp05.model.ClienteI;

import isel.sisinf.grp05.model.cliente.Cliente;
import isel.sisinf.grp05.repo.IRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.Collection;
import java.util.List;


public class ClienteIRepository implements IRepository<ClienteInstitucional, Collection<ClienteInstitucional>, Integer> {
    private final EntityManager _em;

    public ClienteIRepository(EntityManager em) {
        this._em = em;
    }

    @Override
    public List<ClienteInstitucional> findAll() throws Exception {
        return _em.createNamedQuery("Cliente.getAll", ClienteInstitucional.class)
                .getResultList();
    }

    @Override
    public Integer delete(Integer entity) {
        try {
            _em.getTransaction().begin();
            Query query = _em.createNativeQuery("delete from cliente_institucional where nif = (?1)");
            query.setParameter(1, entity);
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


    @Override
    public ClienteInstitucional create(ClienteInstitucional entity) {
        try {
            _em.getTransaction().begin();
            _em.persist(entity);
            _em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
        finally {
            _em.close();
        }
        return entity;
    }

    @Override
    public ClienteInstitucional read(Integer id) {
        ClienteInstitucional c;
        try {
            _em.getTransaction().begin();
            Query query = _em.createNativeQuery("select * from cliente where nif = ?1", Cliente.class);
            query.setParameter(1, id);
            c = (ClienteInstitucional) query.getSingleResult();
            _em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            _em.close();
        }
        return c;
    }

    @Override
    public ClienteInstitucional update(ClienteInstitucional entity) {
        try {
            _em.getTransaction().begin();
            _em.persist(entity);
            _em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            _em.close();
        }
        return entity;
    }
}
