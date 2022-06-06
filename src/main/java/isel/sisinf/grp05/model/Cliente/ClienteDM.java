package isel.sisinf.grp05.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class ClienteDM implements ClienteDataMapper{
    @Override
    public void create(Cliente c) {
        //Entity Manager Start
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("g05");
        EntityManager em = emf.createEntityManager();

        //Check All Business Logic
        //TODO garantir que todos os campos estão bem prenchidos

        //Start transaction
        em.getTransaction().begin();

        //Create, Set And Execute Query
        Query query = em.createNativeQuery("call deleteCliente(?1)");
        query.setParameter(1, c.getNif());
        query.executeUpdate();

        //End Transaction
        em.getTransaction().commit();

        //Entity Manager Close
        em.close();
        emf.close();
    }

    @Override
    public Cliente read(Integer id) {
        return null;
    }

    @Override
    public void update(Cliente c) {

    }

    @Override
    public void delete(Cliente c) {

    }
}
