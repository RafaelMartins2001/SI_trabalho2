package isel.sisinf.grp05.ui;
import isel.sisinf.grp05.model.cliente.Cliente;
import isel.sisinf.grp05.repo.JPAContext;
import java.util.Scanner;


public class App {
    static JPAContext jpa = new JPAContext();

    private static final String exit = "e";

    private static final String create_client = "create client";
    private static final String read_client = "find client";
    private static final String update_client = "update client";
    private static final String delete_client = "delete client";

    private static final String create_vehicle = "add vehicle";
    private static final String read_vehicle = "find vehicle";
    private static final String update_vehicle = "update vehicle";
    private static final String delete_vehicle = "remove vehicle";

    private static final String all_tests = "run tests";
    private static final String test_d1 = "run test d1";
    private static final String test_d2 = "run test d2";
    private static final String test_d3 = "run test d3";
    private static final String test_e1 = "run test e1";
    private static final String test_f1 = "run test f1";
    private static final String test_g1 = "run test g1";
    private static final String test_h1 = "run test h1";
    private static final String test_i1 = "run test i1";
    private static final String test_j1 = "run test j1";
    private static final String test_k1 = "run test k1";
    private static final String test_l1 = "run test l1";

    private static final String help = "Available commands:\n" +
            "\t\""+ exit + "\" -> Exit.\n" +

            "\t\""+ create_client + "\" -> Create a new client.\n" +
            "\t\""+ read_client + "\" -> Find a client.\n" +
            "\t\""+ update_client + "\" -> Update a client.\n" +
            "\t\""+ delete_client + "\" -> Delete a client.\n" +

            "\t\""+ create_vehicle + "\" -> Add a new vehicle.\n" +
            "\t\""+ read_vehicle + "\" -> Find a vehicle.\n" +
            "\t\""+ update_vehicle + "\" -> Update a vehicle.\n" +
            "\t\""+ delete_vehicle + "\" -> Remove a vehicle.\n" +

            "\t\""+ all_tests + "\" -> Runs all tests.\n" +
            "\t\""+ test_d1 + "\" -> Runs test D.1.\n" +
            "\t\""+ test_d2 + "\" -> Runs test D.2.\n" +
            "\t\""+ test_d3 + "\" -> Runs test D.3.\n" +
            "\t\""+ test_e1 + "\" -> Runs test E.1.\n" +
            "\t\""+ test_f1 + "\" -> Runs test F.1.\n" +
            "\t\""+ test_g1 + "\" -> Runs test G.1.\n" +
            "\t\""+ test_h1 + "\" -> Runs test H.1.\n" +
            "\t\""+ test_i1 + "\" -> Runs test I.1.\n" +
            "\t\""+ test_j1 + "\" -> Runs test J.1.\n" +
            "\t\""+ test_k1 + "\" -> Runs test K.1.\n" +
            "\t\""+ test_l1 + "\" -> Runs test L.1.\n";

    static Scanner s = new Scanner(System.in);
    public static void main( String[] args ) {


        println("Please enter a command.");
        String input = s.nextLine();

        while (!input.equals(exit)) {
            switch (input) {

                case create_client: create_client(); break;

                case read_client: read_client(); break;

                case update_client: update_client(); break;

                case delete_client: delete_client(); break;

                case create_vehicle: create_vehicle(); break;

                case read_vehicle: read_vehicle(); break;

                case update_vehicle: update_vehicle(); break;

                case delete_vehicle: delete_vehicle(); break;

                case all_tests: all_tests(); break;

                case test_d1: test_d1(); break;

                case test_d2: test_d2(); break;

                case test_d3: test_d3(); break;

                case test_e1: test_e1(); break;

                case test_f1: test_f1(); break;

                case test_g1: test_g1(); break;

                case test_h1: test_h1(); break;

                case test_i1: test_i1(); break;

                case test_j1: test_j1(); break;

                case test_k1: test_k1(); break;

                case test_l1: test_l1(); break;

                default:
                    println("Not an available command!\n\n" + help);
            }

            input = s.nextLine();
        }
    }

    private static void println(String in){ System.out.println(in); }

    ////////////////////////////////////////////////////////////////////////// COMMANDS //////////////////////////////////////////////////////////////////////////

    private static void create_client() {
        println("Initializing create_client: ***");
        println("create_client concluded");
    }
    private static void read_client() {
        println("Initializing read_client: ***");
        println("Please, enter nif.");
        Integer nif = s.nextInt();
        Cliente c = jpa._clienteRepository.findByKey(nif);
        System.out.print(c.getNif() + " | ");
        System.out.print(c.getEstado() + " | ");
        System.out.print(c.getNome() + " | ");
        System.out.print("\n\n\n");
        println("read_client concluded");
    }
    private static void update_client() {
        println("Initializing update_client: ***");
        println("update_client concluded");
    }
    private static void delete_client() {
        println("Initializing delete_client: ***");
        println("delete_client concluded");
    }
    private static void create_vehicle() {
        println("Initializing create_vehicle: ***");
        println("create_vehicle concluded");
    }
    private static void read_vehicle() {
        println("Initializing read_vehicle: ***");
        println("read_vehicle concluded");
    }
    private static void update_vehicle() {
        println("Initializing update_vehicle: ***");
        println("update_vehicle concluded");
    }
    private static void delete_vehicle() {
        println("Initializing delete_vehicle: ***");
        println("delete_vehicle concluded");
    }

    ////////////////////////////////////////////////////////////////////////// TESTS //////////////////////////////////////////////////////////////////////////

    private static void all_tests() {
    }

    private static void test_d1() {
        println("Initializing Test D.1 Create A New User");
        println("Test D.1 was successful / unsuccessful");
    }

    private static void test_d2() {
        println("Initializing Test D.2 Update A User");
        println("Test D.2 was successful / unsuccessful");
    }

    private static void test_d3() {
        println("Initializing Test D.3 Delete A User");
        println("Test D.3 was successful / unsuccessful");
    }

    private static void test_e1() {
        println("Initializing Test E.1: ***");
        println("Test E.1 was successful / unsuccessful");
    }
    private static void test_f1() {
        println("Initializing Test F.1: ***");
        println("Test F.1 was successful / unsuccessful");
    }
    private static void test_g1() {
        println("Initializing Test G.1: ***");
        println("Test G.1 was successful / unsuccessful");
    }
    private static void test_h1() {
        println("Initializing Test H.1: ***");
        println("Test H.1 was successful / unsuccessful");
    }
    private static void test_i1() {
        println("Initializing Test I.1: ***");
        println("Test I.1 was successful / unsuccessful");
    }
    private static void test_j1() {
        println("Initializing Test J.1: ***");
        println("Test J.1 was successful / unsuccessful");
    }
    private static void test_k1() {
        println("Initializing Test K.1: ***");
        println("Test K.1 was successful / unsuccessful");
    }
    private static void test_l1() {
        println("Initializing Test L.1: ***");
        println("Test L.1 was successful / unsuccessful");
    }
}