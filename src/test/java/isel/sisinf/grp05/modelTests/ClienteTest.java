package isel.sisinf.grp05.modelTests;

import isel.sisinf.grp05.model.alarms.Alarms;
import isel.sisinf.grp05.model.cliente.Cliente;
import isel.sisinf.grp05.model.registoNP.RegistoNP;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.junit.Test;
import java.util.Date;
import java.util.List;

public class ClienteTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("g05");
    EntityManager em = emf.createEntityManager();
/*
    @Test
    public void newClient(){
        try {
            System.out.println("--# CREATE Cliente");
            em.getTransaction().begin();

            Cliente c = new Cliente();


           c.setNif(555555599);
           c.setNome("rui silva");
           c.setMorada("Rua Numero 1");
           c.setTelefone(916726354);
           c.setEstado("Activo");

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
        Integer nif = 555555599;

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
    public void selectAlarms(){
        String matricula = "AB-33-BB";
        Integer ano = 2021;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("g05");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Select Alarms From SQL");

            em.getTransaction().begin();
            Query query = em.createNativeQuery("select getAlarmes(?1, ?2)");
            query.setParameter(1, matricula);
            query.setParameter(2, ano);
            System.out.println(query.getResultList().get(0));
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
    public void proccess(){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("g05");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Proccess registo");

            em.getTransaction().begin();
            Query query = em.createNativeQuery("call proccess()");
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
    public void exercicioG(){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("g05");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Alarme gerido");

            em.getTransaction().begin();

            RegistoNP p = new RegistoNP();
            p.setid(3001);
            p.setdata(new Date("2021-11-12 12:25:22"));
            p.setidGps(2);
            p.setlatitude(40);
            p.setlongitude(30);

            em.persist(p);

            Query query = em.createNativeQuery("select * from alarms");
            System.out.println(query.getResultList());
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
    public void novoVeiculo(){
       String matricula = "SD-45-ER";
       String nomeCondutor = "José Toné";
       Integer telCondutor = 925123456;
       Integer proprietario = 100000000;
       Integer longitude = 12;
       Integer latitude = 13;
       Integer raio = 123;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("g05");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Novo veiculo!");

            em.getTransaction().begin();
            Query query = em.createNativeQuery("call novoVeiculo(?1, ?2, ?3, ?4, ?5, ?6, ?7)");
            query.setParameter(1, matricula);
            query.setParameter(2, nomeCondutor);
            query.setParameter(3, telCondutor);
            query.setParameter(4, proprietario);
            query.setParameter(5, longitude);
            query.setParameter(6, latitude);
            query.setParameter(7, raio);
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
*/
    @Test
    public void Alarms(){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("g05");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Alarms");

            em.getTransaction().begin();

            Query query = em.createNativeQuery("select * from alarms", Alarms.class);
            List<Alarms> alarms =  query.getResultList();
            for(Alarms x: alarms){
                System.out.print(x.getNomeCondutor() + " | ");
                System.out.print(x.getMatricula() + " | ");
                System.out.print(x.getData() + " | ");
                System.out.print(x.getLatitude() + " | ");
                System.out.print(x.getLongitude());
                System.out.print("\n\n\n");
            }
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            em.close();
            emf.close();
        }
    }
}
