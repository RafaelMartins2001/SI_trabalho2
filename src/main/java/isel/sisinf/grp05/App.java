package isel.sisinf.grp05;
import jakarta.persistence.*;
import jakarta.persistence.EntityManagerFactory;

/**
 * Hello world!
 *
 */
    public class App
    {/*
        @SuppressWarnings("unchecked")
        public static void main( String[] args )
        {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("dal-v2");
            EntityManager em = emf.createEntityManager();
            try
            {
                //CREATE
                System.out.println("--# CREATE Student");
                em.getTransaction().begin();

                Country cn = new Country();
                cn.setName("France");


                Student st = new Student(456,"Chiquinho", new java.util.Date(),'M',cn);
                System.out.println(st); //check ID of homeCountry

                //em.persist(cn); //RUN With and Without this line commented.
                em.persist(st);

                em.getTransaction().commit();
                System.out.println(st); //check ID of homeCountry


                System.out.println("\n--# Insert sucedeed Done!");

                //DELETE
                em.getTransaction().begin();
                em.remove(cn);
                em.remove(em.find(Student.class,st.getStudentNumber()));
                em.flush();
                em.getTransaction().commit();
                em.clear();
                System.out.println("\n--# Clean up!!");

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                throw e;
            }
            finally
            {
                em.close();
                emf.close();
            }
        }*/
    }
