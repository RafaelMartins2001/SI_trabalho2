package isel.sisinf.grp05.model.cliente;

import isel.sisinf.grp05.model.alarms.Alarms;
import isel.sisinf.grp05.repo.IRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.Collection;
import java.util.List;


public class ClienteRepository implements IRepository<Cliente, Collection<Cliente>, Integer> {
        private final EntityManager _em;

        public ClienteRepository(EntityManager em){
            this._em = em;
        }

        @Override
        public Cliente findByKey(Integer key) {
            Cliente c;
            try {
                _em.getTransaction().begin();
                Query query = _em.createNativeQuery("select * from cliente where nif = ?1", Cliente.class);
                query.setParameter(1, key);
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
    public List<Cliente> findAll() throws Exception {
        return _em.createNamedQuery("Cliente.getAll", Cliente.class)
                .getResultList();
    }
        @Override
        public Cliente create(Cliente entity) {
            try {
                _em.getTransaction().begin();

                Cliente c = new Cliente();
                c.setNif(555555599);
                c.setNome("rui silva");
                c.setMorada("Rua Numero 1");
                c.setTelefone(916726354);
                c.setEstado("Activo");

                _em.persist(c);
                _em.getTransaction().commit();
            }
            finally {
                _em.close();
            }
            return null;
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
        public Cliente delete(Cliente entity) {
            return null;
        }
    }
