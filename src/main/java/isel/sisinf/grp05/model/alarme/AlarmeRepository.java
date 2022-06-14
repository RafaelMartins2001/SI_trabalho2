package isel.sisinf.grp05.model.alarme;
import isel.sisinf.grp05.repo.IRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Collection;
import java.util.List;


public class AlarmeRepository implements IRepository<Alarme, Collection<Alarme>, Integer> {
    private final EntityManager _em;
    //private final Mapper mapper;

    public AlarmeRepository(EntityManager em) {
        this._em = em;
        //this.mapper = ;
    }

    @Override
    public List<Alarme> findAll() throws Exception {
        return _em.createNamedQuery("Alarme.getAll", Alarme.class)
                .getResultList();
    }

    @Override
    public Alarme create(Alarme entity) {
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
    public Alarme read(Integer id) {
        Alarme c;
        try {
            _em.getTransaction().begin();
            Query query = _em.createNativeQuery("select * from alarmes where id = ?1", Alarme.class);
            query.setParameter(1, id);
            c = (Alarme) query.getSingleResult();
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
    public Alarme update(Alarme entity) {
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

    @Override
    public Integer delete(Integer id) {
        try {
            _em.getTransaction().begin();
            Query query = _em.createNativeQuery("delete from alarmes where id = (?1)");
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
