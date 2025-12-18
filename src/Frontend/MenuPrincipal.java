package Frontend;

import java.util.Scanner;

import backend.funcionalidades.GestaoSistema;
import backend.funcionalidades.Persistencia;
import backend.entidades.Administrador;
import backend.entidades.Coordenador;
import backend.entidades.Investigador;
import backend.excecoes.AdministradorUnicoException;

public class MenuPrincipal {

    private GestaoSistema sistema;
    private Scanner scanner = new Scanner(System.in);

    public MenuPrincipal(GestaoSistema sistema) {
        this.sistema = sistema;
    }

    public void iniciar() {

        while (true) {
            System.out.println("\n===== SISTEMA DE GESTÃO DE PROJETOS =====");
            System.out.println("1. Registar Investigador");
            System.out.println("2. Registar Coordenador");
            System.out.println("3. Registar Administrador");
            System.out.println("4. Login");
            System.out.println("5. Sair");
            System.out.print("Opção: ");

            String op = scanner.nextLine();

            switch (op) {
                case "1": registarInvestigador(); break;
                case "2": registarCoordenador(); break;
                case "3": registarAdministrador(); break;
                case "4": login(); break;
                case "5":
                    Persistencia.guardarSistema(sistema);
                    System.out.println("Sistema guardado. A sair...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // =========================
    // REGISTO DE INVESTIGADOR
    // =========================
    private void registarInvestigador() {

        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Área (Biotecnologia | Energia | Robótica): ");
            String area = scanner.nextLine();

            sistema.criarInvestigador(nome, email, area);
            System.out.println("Investigador registado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao registar investigador: " + e.getMessage());
        }
    }

    // =========================
    // REGISTO DE COORDENADOR
    // =========================
    private void registarCoordenador() {

        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            sistema.criarCoordenador(nome, email, password);
            System.out.println("Coordenador registado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao registar coordenador: " + e.getMessage());
        }
    }

    // =========================
    // REGISTO DE ADMINISTRADOR (ÚNICO)
    // =========================
    private void registarAdministrador() {

        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            sistema.registarAdministrador(nome, email, password);
            System.out.println("Administrador registado com sucesso!");

        } catch (AdministradorUnicoException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao registar administrador: " + e.getMessage());
        }
    }

    // =========================
    // LOGIN (ADMIN / COORD / INV)
    // =========================
    private void login() {

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        Administrador admin = sistema.loginAdministrador(email, password);
        if (admin != null) {
            new menuAdministrador(sistema, admin).mostrar();
            return;
        }

        Coordenador coord = sistema.loginCoordenador(email, password);
        if (coord != null) {
            new MenuCoordenador(sistema, coord).mostrar();
            return;
        }

        Investigador inv = sistema.loginInvestigador(email, password);
        if (inv != null) {
            new MenuInvestigador(sistema, inv).mostrar();
            return;
        }

        System.out.println("Credenciais inválidas.");
    }
}
