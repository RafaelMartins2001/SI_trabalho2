package isel.sisinf.grp05.modelTests;

import isel.sisinf.grp05.model.cliente.Cliente;
import jakarta.persistence.*;
import org.junit.Test;

public class ClienteTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("g05");
    EntityManager em = emf.createEntityManager();

    @Test
    public void newClient(){
        try {
            System.out.println("--# CREATE Cliente");
            em.getTransaction().begin();

            Cliente c = new Cliente();

            em.persist(c);
            em.getTransaction().commit();
        }

        finally {
            em.close();
            emf.close();
        }
    }

    @Test
    public void deleteCParticularFromSQL() {
        Integer nif = 555555555;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("g05");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Delete Private Client From SQL");

            em.getTransaction().begin();
            Query query = em.createNativeQuery("call deleteCliente(?1)");
            query.setParameter(1, nif);
            query.executeUpdate();
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            em.close();
            emf.close();
        }
    }

    @Test
    public void delete(){
        StoredProcedureQuery q = em.createStoredProcedureQuery("fescalar");

        q.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);

        q.registerStoredProcedureParameter( 2, Integer.class, ParameterMode.OUT);

        q.setParameter(1, 111);

        q.execute();

        System.out.printf("dobro de 111:%d\n",q.getOutputParameterValue(2));
    }
}
