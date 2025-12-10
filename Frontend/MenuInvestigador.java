package Frontend;

import java.util.List;
import java.util.Scanner;

import backend.entidades.Atividade;
import backend.entidades.Investigador;
import backend.entidades.Laboratorio;
import backend.entidades.Projeto;
import backend.funcionalidades.FuncInvestigador;
import backend.funcionalidades.GestaoSistema;

public class MenuInvestigador {

    private final GestaoSistema sistema;
    private final FuncInvestigador funcInv;
    private final Investigador investigador;
    private final Scanner scanner = new Scanner(System.in);

    public MenuInvestigador(GestaoSistema sistema, FuncInvestigador funcInv, Investigador investigador) {
        this.sistema = sistema;
        this.funcInv = funcInv;
        this.investigador = investigador;
    }

    public void mostrar() {

        while (true) {
            System.out.println("\n===== MENU DO INVESTIGADOR =====");
            System.out.println("Investigador: " + investigador.getNome() + " (ID " + investigador.getId() + ")");
            System.out.println("1. Ver dados e estatísticas");
            System.out.println("2. Editar nome");
            System.out.println("3. Editar email");
            System.out.println("4. Listar projetos em que participa");
            System.out.println("5. Listar atividades");
            System.out.println("6. Listar laboratórios associados");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            String op = scanner.nextLine();

            switch (op) {
                case "1": verDadosEstatisticas(); break;
                case "2": editarNome(); break;
                case "3": editarEmail(); break;
                case "4": listarProjetos(); break;
                case "5": listarAtividades(); break;
                case "6": listarLaboratorios(); break;
                case "0": return;
                default:  System.out.println("Opção inválida.");
            }
        }
    }

    // ============================================================
    // 1. Ver dados e estatísticas
    // ============================================================

    private void verDadosEstatisticas() {
        System.out.println("\n--- Dados do Investigador ---");
        System.out.println("ID: " + investigador.getId());
        System.out.println("Nome: " + investigador.getNome());
        System.out.println("Email: " + investigador.getEmail());

        int nProj = funcInv.obterNumeroProjetos(investigador);
        int nAtiv = funcInv.obterNumeroAtividades(investigador);
        double horas = funcInv.obterTotalHoras(investigador);

        System.out.println("\n--- Estatísticas ---");
        System.out.println("N.º de projetos: " + nProj);
        System.out.println("N.º de atividades: " + nAtiv);
        System.out.println("Total de horas em atividades: " + horas);
    }

    // ============================================================
    // 2. Editar nome
    // ============================================================

    private void editarNome() {
        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();

        if (funcInv.editarNome(investigador, novoNome))
            System.out.println("Nome atualizado com sucesso.");
        else
            System.out.println("Erro ao atualizar nome.");
    }

    // ============================================================
    // 3. Editar email
    // ============================================================

    private void editarEmail() {
        System.out.print("Novo email: ");
        String novoEmail = scanner.nextLine();

        if (funcInv.editarEmail(investigador, novoEmail))
            System.out.println("Email atualizado com sucesso.");
        else
            System.out.println("Erro ao atualizar email.");
    }

    // ============================================================
    // 4. Listar projetos
    // ============================================================

    private void listarProjetos() {
        List<Projeto> projetos = funcInv.listarProjetos(investigador);

        if (projetos.isEmpty()) {
            System.out.println("Não está associado a nenhum projeto.");
            return;
        }

        System.out.println("\n--- Projetos em que participa ---");
        for (Projeto p : projetos) {
            System.out.println(p);
        }
    }

    // ============================================================
    // 5. Listar atividades
    // ============================================================

    private void listarAtividades() {
        List<Atividade> atividades = funcInv.listarAtividadesDoInvestigador(investigador);

        if (atividades.isEmpty()) {
            System.out.println("Ainda não tem atividades registadas.");
            return;
        }

        System.out.println("\n--- Atividades ---");
        for (Atividade a : atividades) {
            System.out.println("Atividade ID: " + a.getIdAtividade() +
                               " | Projeto: " + a.getProjetoAssociado().getTituloProjeto() +
                               " | Tipo: " + a.getTipoAtividade() +
                               " | Data: " + a.getData() +
                               " | Duração: " + a.getDuracao());
        }
    }

    // ============================================================
    // 6. Listar laboratórios associados
    // ============================================================

    private void listarLaboratorios() {
        List<Laboratorio> labs = funcInv.listarLaboratoriosDoInvestigador(investigador);

        if (labs.isEmpty()) {
            System.out.println("Não tem laboratórios associados através de projetos.");
            return;
        }

        System.out.println("\n--- Laboratórios associados ---");
        for (Laboratorio lab : labs) {
            System.out.println(lab.getId() + " - " + lab.getNome() + " (" + lab.getLocalizacao() + ")");
        }
    }
}
