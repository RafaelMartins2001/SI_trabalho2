package isel.sisinf.grp05.Assignments;
import isel.sisinf.grp05.model.cliente.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.glassfish.jaxb.core.v2.TODO;

public class Tests {

    private EntityManager _em;

    public Tests(EntityManager em){
        this._em = em;
    }

    private void d1(Cliente cliente, Integer cc){
        try {
            _em.getTransaction().begin();
            Query query = _em.createNativeQuery("call insertCliente(?1, ?2, ?3, ?4, ?5, ?6, ?7)");
            query.setParameter(1, cliente.getNif());
            query.setParameter(2, cliente.getNome());
            query.setParameter(3, cliente.getMorada());
            query.setParameter(4, cliente.getTelefone());
            query.setParameter(5, cliente.getReferencia());
            query.setParameter(6, cc);
            query.executeUpdate();
            _em.getTransaction().rollback();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
        finally {
            _em.close();
        }
    }

    private void d2(Cliente cliente){
        try {
            _em.getTransaction().begin();
            Query query = _em.createNativeQuery("call updateCliente(?1, ?2, ?3, ?4, ?5, null)");
            query.setParameter(1, cliente.getNif());
            query.setParameter(2, cliente.getNome());
            query.setParameter(3, cliente.getMorada());
            query.setParameter(4, cliente.getTelefone());
            query.setParameter(5, cliente.getReferencia());
            query.executeUpdate();
            _em.getTransaction().rollback();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
        finally {
            _em.close();
        }
    }


    private void d3(Integer nif) {
        try {
            _em.getTransaction().begin();
            Query query = _em.createNativeQuery("call deleteCliente(?1)");
            query.setParameter(1, nif);
            query.executeUpdate();
            _em.getTransaction().rollback();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            _em.close();
        }
    }
    //TODO: Implementar o resto dos testes com o call até ao L
}
