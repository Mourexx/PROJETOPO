package Frontend;

import java.util.Scanner;

import backend.entidades.Administrador;
import backend.entidades.Coordenador;
import backend.entidades.Investigador;
import backend.entidades.Laboratorio;
import backend.entidades.Projeto;

import backend.funcionalidades.FuncAdministrador;
import backend.funcionalidades.GestaoSistema;

public class menuAdministrador {

    private GestaoSistema sistema;
    private FuncAdministrador funcAdmin;
    private Administrador admin;
    private Scanner scanner = new Scanner(System.in);

    public menuAdministrador(GestaoSistema sistema, FuncAdministrador funcAdmin, Administrador admin) {
        this.sistema = sistema;
        this.funcAdmin = funcAdmin;
        this.admin = admin;
    }

    public void mostrar() {
        while (true) {
            System.out.println("\n===== MENU ADMINISTRADOR =====");
            System.out.println("1. Criar Coordenador");
            System.out.println("2. Criar Administrador");
            System.out.println("3. Criar Laboratório");
            System.out.println("4. Criar Projeto");
            System.out.println("5. Listar Investigadores");
            System.out.println("6. Listar Coordenadores");
            System.out.println("7. Listar Administradores");
            System.out.println("8. Listar Laboratórios");
            System.out.println("9. Listar Projetos");
            System.out.println("10. Remover Investigador");
            System.out.println("11. Remover Coordenador");
            System.out.println("12. Remover Laboratório");
            System.out.println("13. Remover Projeto");
            System.out.println("14. Associar Investigador a Laboratório");
            System.out.println("15. Associar Investigador a Projeto");
            System.out.println("16. Associar Laboratório a Projeto");
            System.out.println("17. Atualizar Estado de Projeto");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            String op = scanner.nextLine();

            switch (op) {
                case "1": criarCoordenador(); break;
                case "2": criarAdministrador(); break;
                case "3": criarLaboratorio(); break;
                case "4": criarProjeto(); break;
                case "5": listarInvestigadores(); break;
                case "6": listarCoordenadores(); break;
                case "7": listarAdministradores(); break;
                case "8": listarLaboratorios(); break;
                case "9": listarProjetos(); break;
                case "10": removerInvestigador(); break;
                case "11": removerCoordenador(); break;
                case "12": removerLaboratorio(); break;
                case "13": removerProjeto(); break;
                case "14": associarInvestigadorLaboratorio(); break;
                case "15": associarInvestigadorProjeto(); break;
                case "16": associarLaboratorioProjeto(); break;
                case "17": atualizarEstadoProjeto(); break;
                case "0": return;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    // ============================================================
    //  OPÇÕES DO MENU
    // ============================================================

    private void criarCoordenador() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String pass = scanner.nextLine();

        Coordenador c = funcAdmin.criarCoordenador(nome, email, pass);

        if (c != null) System.out.println("Coordenador criado com sucesso!");
        else System.out.println("Erro: email já existe.");
    }

    private void criarAdministrador() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String pass = scanner.nextLine();

        Administrador a = funcAdmin.criarAdministrador(nome, email, pass);

        if (a != null) System.out.println("Administrador criado!");
        else System.out.println("Erro: email já existe.");
    }

    private void criarLaboratorio() {
        System.out.print("Nome do laboratório: ");
        String nome = scanner.nextLine();

        System.out.print("Localização: ");
        String localizacao = scanner.nextLine();

        Laboratorio lab = funcAdmin.criarLaboratorio(nome, localizacao);

        if (lab != null) System.out.println("Laboratório criado com sucesso!");
        else System.out.println("Erro ao criar laboratório.");
    }

    private void criarProjeto() {
        System.out.print("Título do projeto: ");
        String titulo = scanner.nextLine();

        System.out.print("Área científica: ");
        String area = scanner.nextLine();

        System.out.println("\n--- Coordenadores disponíveis ---");
        for (Coordenador c : sistema.listarCoordenadores()) {
            System.out.println(c.getId() + " - " + c.getNome());
        }

        System.out.print("ID do coordenador responsável: ");
        int idCoord = Integer.parseInt(scanner.nextLine());

        Projeto p = funcAdmin.criarProjeto(titulo, area, idCoord);

        if (p != null) System.out.println("Projeto criado com sucesso!");
        else System.out.println("Erro ao criar projeto.");
    }

    private void listarInvestigadores() {
        for (Investigador i : funcAdmin.listarInvestigadores()) {
            System.out.println(i);
        }
    }

    private void listarCoordenadores() {
        for (Coordenador c : funcAdmin.listarCoordenadores()) {
            System.out.println(c);
        }
    }

    private void listarAdministradores() {
        for (Administrador a : funcAdmin.listarAdministradores()) {
            System.out.println(a);
        }
    }

    private void listarLaboratorios() {
        for (Laboratorio l : funcAdmin.listarLaboratorios()) {
            System.out.println(l);
        }
    }

    private void listarProjetos() {
        for (Projeto p : funcAdmin.listarProjetos()) {
            System.out.println(p);
        }
    }

    private void removerInvestigador() {
        System.out.print("ID do investigador: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (funcAdmin.removerInvestigador(id)) System.out.println("Investigador removido!");
        else System.out.println("Erro ao remover investigador.");
    }

    private void removerCoordenador() {
        System.out.print("ID do coordenador: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (funcAdmin.removerCoordenador(id)) System.out.println("Coordenador removido!");
        else System.out.println("Erro ao remover coordenador.");
    }

    private void removerLaboratorio() {
        System.out.print("ID do laboratório: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (funcAdmin.removerLaboratorio(id)) System.out.println("Laboratório removido!");
        else System.out.println("Erro ao remover laboratório.");
    }

    private void removerProjeto() {
        System.out.print("ID do projeto: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (funcAdmin.removerProjeto(id)) System.out.println("Projeto removido!");
        else System.out.println("Erro ao remover projeto.");
    }

    private void associarInvestigadorLaboratorio() {
        System.out.print("ID do laboratório: ");
        int idLab = Integer.parseInt(scanner.nextLine());

        System.out.print("ID do investigador: ");
        int idInv = Integer.parseInt(scanner.nextLine());

        if (funcAdmin.associarInvestigadorLaboratorio(idLab, idInv))
            System.out.println("Associação feita!");
        else
            System.out.println("Erro ao associar.");
    }

    private void associarInvestigadorProjeto() {
        System.out.print("ID do projeto: ");
        int idProjeto = Integer.parseInt(scanner.nextLine());

        System.out.print("ID do investigador: ");
        int idInv = Integer.parseInt(scanner.nextLine());

        if (funcAdmin.associarInvestigadorProjeto(idProjeto, idInv))
            System.out.println("Associação feita!");
        else
            System.out.println("Erro ao associar.");
    }

    private void associarLaboratorioProjeto() {
        System.out.print("ID do projeto: ");
        int idProjeto = Integer.parseInt(scanner.nextLine());

        System.out.print("ID do laboratório: ");
        int idLab = Integer.parseInt(scanner.nextLine());

        if (funcAdmin.associarLaboratorioProjeto(idProjeto, idLab))
            System.out.println("Associação feita!");
        else
            System.out.println("Erro ao associar.");
    }

    private void atualizarEstadoProjeto() {
        System.out.print("ID do projeto: ");
        int idProjeto = Integer.parseInt(scanner.nextLine());

        System.out.print("Novo estado (Em Curso / Concluído / Suspenso): ");
        String estado = scanner.nextLine();

        if (funcAdmin.alterarEstadoProjeto(idProjeto, estado))
            System.out.println("Estado atualizado!");
        else
            System.out.println("Erro ao atualizar estado.");
    }
}
