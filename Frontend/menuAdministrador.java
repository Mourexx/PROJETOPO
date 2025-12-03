import java.util.List;
import java.util.Scanner;

public class MenuAdministrador {

    private static final Scanner scanner = new Scanner(System.in);
    private static final GestaoSistema sistema = new GestaoSistema();
    private static final FuncAdministrador funcAdmin = new FuncAdministrador(sistema);

    public static void main(String[] args) {
        while (true) {
            exibirMenuPrincipal();
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    criarAdministrador();
                    break;
                case 2:
                    criarCoordenador();
                    break;
                case 3:
                    criarInvestigador();
                    break;
                case 4:
                    criarLaboratorio();
                    break;
                case 5:
                    criarProjeto();
                    break;
                case 6:
                    listarEntidades();
                    break;
                case 7:
                    removerEntidade();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    return; // Sai do programa
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    // Exibe o menu principal
    private static void exibirMenuPrincipal() {
        System.out.println("\n==== MENU ADMINISTRADOR ====");
        System.out.println("1. Criar Administrador");
        System.out.println("2. Criar Coordenador");
        System.out.println("3. Criar Investigador");
        System.out.println("4. Criar Laboratório");
        System.out.println("5. Criar Projeto");
        System.out.println("6. Listar Entidades");
        System.out.println("7. Remover Entidade");
        System.out.println("8. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Função para criar um novo Administrador
    private static void criarAdministrador() {
        System.out.print("Digite o nome do administrador: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o e-mail do administrador: ");
        String email = scanner.nextLine();

        Administrador admin = funcAdmin.registarAdministrador(0, nome, email);
        if (admin != null) {
            System.out.println("Administrador criado com sucesso: " + admin);
        } else {
            System.out.println("Erro: Administrador com esse email ou ID já existe.");
        }
    }

    // Função para criar um novo Coordenador
    private static void criarCoordenador() {
        System.out.print("Digite o nome do coordenador: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o e-mail do coordenador: ");
        String email = scanner.nextLine();

        Coordenador coord = funcAdmin.registarCoordenador(0, nome, email);
        if (coord != null) {
            System.out.println("Coordenador criado com sucesso: " + coord);
        } else {
            System.out.println("Erro: Coordenador com esse email ou ID já existe.");
        }
    }

    // Função para criar um novo Investigador
    private static void criarInvestigador() {
        System.out.print("Digite o nome do investigador: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o e-mail do investigador: ");
        String email = scanner.nextLine();
        System.out.print("Digite a área do investigador: ");
        String area = scanner.nextLine();

        Investigador inv = funcAdmin.registarInvestigador(nome, email, area);
        if (inv != null) {
            System.out.println("Investigador criado com sucesso: " + inv);
        } else {
            System.out.println("Erro: Investigador com esse email ou ID já existe.");
        }
    }

    // Função para criar um novo Laboratório
    private static void criarLaboratorio() {
        System.out.print("Digite o nome do laboratório: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a localização do laboratório: ");
        String localizacao = scanner.nextLine();

        Laboratorio lab = funcAdmin.registarLaboratorio(nome, localizacao);
        if (lab != null) {
            System.out.println("Laboratório criado com sucesso: " + lab);
        } else {
            System.out.println("Erro: Laboratório com esse ID já existe.");
        }
    }

    // Função para criar um novo Projeto
    private static void criarProjeto() {
        System.out.print("Digite o título do projeto: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite a área do projeto: ");
        String area = scanner.nextLine();
        System.out.print("Digite o ID do coordenador responsável: ");
        int idCoordenador = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Projeto projeto = funcAdmin.registarProjeto(titulo, area, idCoordenador);
        if (projeto != null) {
            System.out.println("Projeto criado com sucesso: " + projeto);
        } else {
            System.out.println("Erro: Não foi possível criar o projeto.");
        }
    }

    // Função para listar todas as entidades
    private static void listarEntidades() {
        System.out.println("\n==== LISTA DE ENTIDADES ====");
        System.out.println("Administradores:");
        List<Administrador> admins = funcAdmin.verTodosAdministradores();
        admins.forEach(admin -> System.out.println(admin));

        System.out.println("\nCoordenadores:");
        List<Coordenador> coords = funcAdmin.verTodosCoordenadores();
        coords.forEach(coord -> System.out.println(coord));

        System.out.println("\nInvestigadores:");
        List<Investigador> invs = funcAdmin.verTodosInvestigadores();
        invs.forEach(inv -> System.out.println(inv));

        System.out.println("\nLaboratórios:");
        List<Laboratorio> labs = funcAdmin.verTodosLaboratorios();
        labs.forEach(lab -> System.out.println(lab));

        System.out.println("\nProjetos:");
        List<Projeto> projetos = funcAdmin.verTodosProjetos();
        projetos.forEach(projeto -> System.out.println(projeto));
    }

    // Função para remover uma entidade
    private static void removerEntidade() {
        System.out.println("\nSelecione a entidade para remover:");
        System.out.println("1. Administrador");
        System.out.println("2. Coordenador");
        System.out.println("3. Investigador");
        System.out.println("4. Laboratório");
        System.out.println("5. Projeto");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Digite o ID da entidade a ser removida: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        boolean sucesso = false;
        switch (opcao) {
            case 1:
                sucesso = funcAdmin.removerInvestigador(id);
                break;
            case 2:
                sucesso = funcAdmin.removerCoordenador(id);
                break;
            case 3:
                sucesso = funcAdmin.removerInvestigador(id);
                break;
            case 4:
                sucesso = funcAdmin.removerLaboratorio(id);
                break;
            case 5:
                sucesso = funcAdmin.removerProjeto(id);
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        if (sucesso) {
            System.out.println("Entidade removida com sucesso.");
        } else {
            System.out.println("Erro ao remover a entidade.");
        }
    }
}
