package Frontend;

import java.util.Scanner;
import java.util.List;

import backend.entidades.Atividade;
import backend.entidades.Coordenador;
import backend.entidades.Investigador;
import backend.entidades.Laboratorio;
import backend.entidades.Projeto;

import backend.funcionalidades.FuncCoordenador;
import backend.funcionalidades.GestaoSistema;

public class MenuCoordenador {

    private GestaoSistema sistema;
    private FuncCoordenador funcCoord;
    private Coordenador coordenador;
    private Scanner scanner = new Scanner(System.in);

    public MenuCoordenador(GestaoSistema sistema, FuncCoordenador funcCoord, Coordenador coordenador) {
        this.sistema = sistema;
        this.funcCoord = funcCoord;
        this.coordenador = coordenador;
    }

    public void mostrar() {

        while (true) {
            System.out.println("\n===== MENU DO COORDENADOR =====");
            System.out.println("1. Criar Projeto");
            System.out.println("2. Listar Meus Projetos");
            System.out.println("3. Adicionar Investigador a Projeto");
            System.out.println("4. Remover Investigador de Projeto");
            System.out.println("5. Associar Laboratório a Projeto");
            System.out.println("6. Atualizar Estado de Projeto");
            System.out.println("7. Listar Equipa de um Projeto");
            System.out.println("8. Listar Laboratórios de um Projeto");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            String op = scanner.nextLine();

            switch (op) {
                case "1": criarProjeto(); break;
                case "2": listarMeusProjetos(); break;
                case "3": adicionarInvestigadorProjeto(); break;
                case "4": removerInvestigadorProjeto(); break;
                case "5": associarLaboratorioProjeto(); break;
                case "6": atualizarEstadoProjeto(); break;
                case "7": listarEquipaProjeto(); break;
                case "8": listarLaboratoriosProjeto(); break;
                case "0": return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // ============================================================
    //  1. Criar projeto
    // ============================================================

    private void criarProjeto() {
        System.out.print("Título do projeto: ");
        String titulo = scanner.nextLine();

        System.out.print("Área científica: ");
        String area = scanner.nextLine();

        Projeto p = funcCoord.criarProjeto(coordenador, titulo, area);

        if (p != null)
            System.out.println("Projeto criado com sucesso!");
        else
            System.out.println("Erro ao criar projeto.");
    }

    // ============================================================
    //  2. Listar projetos do coordenador
    // ============================================================

    private void listarMeusProjetos() {
        List<Projeto> lista = funcCoord.listarProjetosDoCoordenador(coordenador);

        System.out.println("\n--- Projetos sob sua coordenação ---");
        for (Projeto p : lista) {
            System.out.println(p);
        }
    }

    // ============================================================
    //  3. Adicionar investigador a projeto
    // ============================================================

    private void adicionarInvestigadorProjeto() {
        listarMeusProjetos();

        System.out.print("\nID do projeto: ");
        int idProjeto = Integer.parseInt(scanner.nextLine());

        System.out.println("\n--- Investigadores disponíveis ---");
        for (Investigador inv : sistema.listarInvestigadores()) {
            System.out.println(inv.getId() + " - " + inv.getNome());
        }

        System.out.print("ID do investigador: ");
        int idInv = Integer.parseInt(scanner.nextLine());

        if (funcCoord.adicionarInvestigadorProjeto(coordenador, idProjeto, idInv))
            System.out.println("Investigador associado com sucesso!");
        else
            System.out.println("Erro ao associar investigador.");
    }

    // ============================================================
    //  4. Remover investigador de projeto
    // ============================================================

    private void removerInvestigadorProjeto() {
        listarMeusProjetos();

        System.out.print("\nID do projeto: ");
        int idProjeto = Integer.parseInt(scanner.nextLine());

        Projeto projeto = sistema.getProjetoPorId(idProjeto);

        if (projeto == null || !projeto.getCoordenador().equals(coordenador)) {
            System.out.println("Não tem permissão para editar este projeto.");
            return;
        }

        System.out.println("\n--- Equipa atual ---");
        for (Investigador inv : projeto.getEquipaInvestigadores()) {
            System.out.println(inv.getId() + " - " + inv.getNome());
        }

        System.out.print("ID do investigador a remover: ");
        int idInv = Integer.parseInt(scanner.nextLine());

        if (funcCoord.removerInvestigadorProjeto(coordenador, idProjeto, idInv))
            System.out.println("Investigador removido!");
        else
            System.out.println("Erro ao remover investigador.");
    }

    // ============================================================
    //  5. Associar laboratório a projeto
    // ============================================================

    private void associarLaboratorioProjeto() {
        listarMeusProjetos();

        System.out.print("\nID do projeto: ");
        int idProjeto = Integer.parseInt(scanner.nextLine());

        System.out.println("\n--- Laboratórios disponíveis ---");
        for (Laboratorio lab : sistema.listarLaboratorios()) {
            System.out.println(lab.getId() + " - " + lab.getNome());
        }

        System.out.print("ID do laboratório: ");
        int idLab = Integer.parseInt(scanner.nextLine());

        if (funcCoord.adicionarLaboratorioProjeto(coordenador, idProjeto, idLab))
            System.out.println("Laboratório associado com sucesso!");
        else
            System.out.println("Erro ao associar laboratório.");
    }

    // ============================================================
    //  6. Atualizar estado de projeto
    // ============================================================

    private void atualizarEstadoProjeto() {
        listarMeusProjetos();

        System.out.print("\nID do projeto: ");
        int idProjeto = Integer.parseInt(scanner.nextLine());

        System.out.print("Novo estado (Em Curso / Concluído / Suspenso): ");
        String estado = scanner.nextLine();

        if (funcCoord.atualizarEstadoProjeto(coordenador, idProjeto, estado))
            System.out.println("Estado atualizado!");
        else
            System.out.println("Erro: não autorizado ou ID inválido.");
    }

    // ============================================================
    //  7. Listar equipa de um projeto
    // ============================================================

    private void listarEquipaProjeto() {

        listarMeusProjetos();

        System.out.print("\nID do projeto: ");
        int idProjeto = Integer.parseInt(scanner.nextLine());

        Projeto p = sistema.getProjetoPorId(idProjeto);

        if (p == null || !p.getCoordenador().equals(coordenador)) {
            System.out.println("Não tem permissão para ver este projeto.");
            return;
        }

        System.out.println("\n--- Equipa do Projeto ---");
        for (Investigador inv : p.getEquipaInvestigadores()) {
            System.out.println(inv.getId() + " - " + inv.getNome());
        }
    }

    // ============================================================
    //  8. Listar laboratórios associados a um projeto
    // ============================================================

    private void listarLaboratoriosProjeto() {

        listarMeusProjetos();

        System.out.print("\nID do projeto: ");
        int idProjeto = Integer.parseInt(scanner.nextLine());

        Projeto p = sistema.getProjetoPorId(idProjeto);

        if (p == null || !p.getCoordenador().equals(coordenador)) {
            System.out.println("Não tem permissão!");
            return;
        }

        System.out.println("\n--- Laboratórios associados ---");
        for (Laboratorio lab : p.getLaboratoriosEnvolvidos()) {
            System.out.println(lab.getId() + " - " + lab.getNome());
        }
    }
}
