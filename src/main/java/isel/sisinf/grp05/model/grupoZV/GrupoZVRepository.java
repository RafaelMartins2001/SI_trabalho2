package isel.sisinf.grp05.model.grupoZV;

import isel.sisinf.grp05.model.cliente.Cliente;
import isel.sisinf.grp05.repo.IRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Collection;
import java.util.List;


public class GrupoZVRepository implements IRepository<Cliente, Collection<Cliente>, Integer> {
        private final EntityManager _em;
        //private final Mapper mapper;

        public GrupoZVRepository(EntityManager em){
            this._em = em;
            //this.mapper = ;
        }

        @Override
        public Cliente findByKey(Integer key) {
            return _em.createNamedQuery("Cliente.findByKey", Cliente.class)
                    .setParameter("key", key)
                    .getSingleResult();
        }

        @Override
        public List<Cliente> getAll() throws Exception {
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
        public Cliente delete(Cliente entity) {
            return null;
        }
    }
