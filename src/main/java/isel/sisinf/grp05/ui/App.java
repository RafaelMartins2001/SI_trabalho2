package isel.sisinf.grp05.ui;

import isel.sisinf.grp05.repo.JPAContext;


public class App {
    /*
    * TODO
    *   criar o while que recebe os comandos
    *   criar uma funcao por comando
    *   criar a mensagem default
    *
    * */

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