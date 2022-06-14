package isel.sisinf.grp05.Assignments;
import isel.sisinf.grp05.model.cliente.ClienteRepository;
import isel.sisinf.grp05.model.cliente.Cliente;
import isel.sisinf.grp05.model.cliente.ClienteRepository;
import isel.sisinf.grp05.model.veiculo.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Assignment1 {
    private static void createClient(EntityManager em){
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
        }
    }

    private static void selectClient(EntityManager em, Integer nif) {

    }

    private static void deleteClient(EntityManager em) {
        Integer nif = 555555599;
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
        }
    }

    /*private static void createVehicle(EntityManager em){
        try {
            System.out.println("--# CREATE Vehicle");
            em.getTransaction().begin();

            Veiculo c = new Veiculo();


            c.setidGps(555555599);
            c.setmatricula("rui silva");
            c.setnomeCondutor("Rua Numero 1");
            c.setnumAlarmes(916726354);
            c.setproprieatario(1);
            c.settelCondutor(925140138);

            em.persist(c);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }*/

    private static void deleteVehicle(EntityManager em){

    }
}
