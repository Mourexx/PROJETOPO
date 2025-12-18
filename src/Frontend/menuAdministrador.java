package Frontend;

import java.util.Scanner;

import backend.entidades.Administrador;
import backend.entidades.Coordenador;
import backend.entidades.Projeto;
import backend.excecoes.AdministradorUnicoException;
import backend.funcionalidades.FuncAdministrador;
import backend.funcionalidades.GestaoSistema;

public class menuAdministrador {

    private GestaoSistema sistema;
    private FuncAdministrador funcAdmin;
    private Administrador admin;
    private Scanner scanner = new Scanner(System.in);

    // ✅ CONSTRUTOR ALINHADO COM MenuPrincipal
    public menuAdministrador(GestaoSistema sistema, Administrador admin) {
        this.sistema = sistema;
        this.admin = admin;
        this.funcAdmin = new FuncAdministrador(sistema);
    }

    public void mostrar() {

        while (true) {
            System.out.println("\n===== MENU ADMINISTRADOR =====");
            System.out.println("1. Criar Coordenador");
            System.out.println("2. Criar Administrador");
            System.out.println("3. Criar Laboratório");
            System.out.println("4. Criar Projeto");
            System.out.println("5. Listar Projetos");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            String op = scanner.nextLine();

            switch (op) {
                case "1": criarCoordenador(); break;
                case "2": criarAdministrador(); break;
                case "3": criarLaboratorio(); break;
                case "4": criarProjeto(); break;
                case "5": listarProjetos(); break;
                case "0": return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    private void criarCoordenador() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String pass = scanner.nextLine();

        funcAdmin.criarCoordenador(nome, email, pass);
        System.out.println("Coordenador criado com sucesso.");
    }

    private void criarAdministrador() {
        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Password: ");
            String pass = scanner.nextLine();

            sistema.registarAdministrador(nome, email, pass);
            System.out.println("Administrador criado com sucesso.");

        } catch (AdministradorUnicoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void criarLaboratorio() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Localização: ");
        String loc = scanner.nextLine();

        funcAdmin.criarLaboratorio(nome, loc);
        System.out.println("Laboratório criado.");
    }

    private void criarProjeto() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Área científica: ");
        String area = scanner.nextLine();

        System.out.println("Coordenadores:");
        for (Coordenador c : sistema.listarCoordenadores()) {
            System.out.println(c.getId() + " - " + c.getNome());
        }

        System.out.print("ID do coordenador: ");
        int id = Integer.parseInt(scanner.nextLine());

        funcAdmin.criarProjeto(titulo, area, id);
        System.out.println("Projeto criado.");
    }

    private void listarProjetos() {
        for (Projeto p : sistema.listarProjetos()) {
            System.out.println(p);
        }
    }
}
