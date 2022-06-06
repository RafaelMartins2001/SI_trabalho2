package isel.sisinf.grp05.model.ui;

import isel.sisinf.grp05.repo.JPAContext;

public class App {
    public static void main( String[] args ) throws Exception {
        try(JPAContext ctx= new JPAContext()) {
            ctx.beginTransaction();

            System.out.println(ctx.rand_fx(1));

            ctx.commit();
        }

        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}