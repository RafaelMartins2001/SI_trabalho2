package isel.sisinf.grp05.modelTests;

import isel.sisinf.grp05.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.Test;

public class ClienteTest {
   @Test
    public void newClient(){
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("g05");
       EntityManager em = emf.createEntityManager();
       try
       {
           System.out.println("--# CREATE Cliente");
           em.getTransaction().begin();

           Cliente c = new Cliente();

           c.setNif(555555555);
           c.setNome("rui silva");
           c.setMorada("Rua Numero 1");
           c.setTelefone(916726354);
           c.setEstado("Activo");

           em.persist(c);
           em.getTransaction().commit();

        }finally {
           em.close();
           emf.close();
       }
   }


}
