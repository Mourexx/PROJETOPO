package Frontend;

import java.util.Scanner;

import backend.funcionalidades.GestaoSistema;
import backend.funcionalidades.Persistencia;
import backend.funcionalidades.FuncAdministrador;
import backend.funcionalidades.FuncCoordenador;
import backend.funcionalidades.FuncInvestigador;

import backend.entidades.Administrador;
import backend.entidades.Coordenador;
import backend.entidades.Investigador;

public class MenuPrincipal {

    private GestaoSistema sistema;
    private Scanner scanner;

    private FuncAdministrador funcAdmin;
    private FuncCoordenador funcCoord;
    private FuncInvestigador funcInv;

    public MenuPrincipal(GestaoSistema sistema) {
        this.sistema = sistema;
        this.scanner = new Scanner(System.in);

        this.funcAdmin = new FuncAdministrador(sistema);
        this.funcCoord = new FuncCoordenador(sistema);
        this.funcInv = new FuncInvestigador(sistema);
    }

    public void iniciar() {

        while (true) {

            System.out.println("\n===== SISTEMA DE GESTÃO DE PROJETOS =====");
            System.out.println("1. Login Administrador");
            System.out.println("2. Login Coordenador");
            System.out.println("3. Login Investigador");
            System.out.println("4. Sair e Guardar");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {

                case "1": loginAdministrador(); break;
                case "2": loginCoordenador(); break;
                case "3": loginInvestigador(); break;
                case "4":
                    Persistencia.guardarSistema(sistema);
                    System.out.println("Sistema guardado. A sair...");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void loginAdministrador() {
        System.out.print("\nEmail: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        Administrador admin = sistema.loginAdministrador(email, pass);

        if (admin == null) {
            System.out.println("Credenciais inválidas!");
            return;
        }

        new MenuAdministrador(sistema, funcAdmin, admin).mostrar();
    }

    private void loginCoordenador() {
        System.out.print("\nEmail: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        Coordenador coord = sistema.loginCoordenador(email, pass);

        if (coord == null) {
            System.out.println("Credenciais inválidas!");
            return;
        }

        new MenuCoordenador(sistema, funcCoord, coord).mostrar();
    }

    private void loginInvestigador() {
        System.out.print("\nEmail: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        Investigador inv = sistema.loginInvestigador(email, pass);

        if (inv == null) {
            System.out.println("Credenciais inválidas!");
            return;
        }

        new MenuInvestigador(sistema, funcInv, inv).mostrar();
    }
}
