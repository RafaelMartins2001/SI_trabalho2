package isel.sisinf.grp05.model.cliente;

import isel.sisinf.grp05.repo.IRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Collection;
import java.util.List;


public class ClienteRepository implements IRepository<Cliente, Collection<Cliente>, Integer> {
        private final EntityManager _em;

        public ClienteRepository(EntityManager em){
            this._em = em;
        }

        @Override
        public List<Cliente> findAll() throws Exception {
            return _em.createNamedQuery("Cliente.getAll", Cliente.class)
                    .getResultList();
        }
        @Override
        public Cliente create(Cliente entity) {
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
        public Cliente read(Integer nif) {
            Cliente c;
            try {
                _em.getTransaction().begin();
                Query query = _em.createNativeQuery("select * from cliente where nif = ?1", Cliente.class);
                query.setParameter(1, nif);
                c = (Cliente) query.getSingleResult();
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
        public Cliente update(Cliente entity) {
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
        public Integer delete(Integer entity) {
            try {
                _em.getTransaction().begin();
                Query query = _em.createNativeQuery("call deleteCliente(?1)");
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
}
