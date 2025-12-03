import java.util.Scanner;

public class MenuCoordenador {

    private GestaoSistema sistema;  // Sistema onde estão as funcionalidades
    private Coordenador coordenadorAutenticado;  // Coordenador autenticado no sistema

    public MenuCoordenador(GestaoSistema sistema) {
        this.sistema = sistema;
    }

    // Método para autenticar coordenador
    public void autenticarCoordenador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o email do coordenador:");
        String email = scanner.nextLine();
        
        coordenadorAutenticado = sistema.autenticarCoordenador(email);

        if (coordenadorAutenticado == null) {
            System.out.println("Coordenador não encontrado ou email incorreto.");
        } else {
            System.out.println("Coordenador " + coordenadorAutenticado.getNome() + " autenticado com sucesso.");
        }
    }

    // Menu principal
    public void exibirMenu() {
        if (coordenadorAutenticado == null) {
            System.out.println("Nenhum coordenador autenticado. Por favor, faça login.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== MENU COORDENADOR ====");
            System.out.println("1 - Criar Projeto");
            System.out.println("2 - Adicionar Investigador ao Projeto");
            System.out.println("3 - Remover Investigador do Projeto");
            System.out.println("4 - Registar Atividade");
            System.out.println("5 - Atualizar Estado do Projeto");
            System.out.println("6 - Listar Projetos do Coordenador");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    criarProjeto(scanner);
                    break;
                case 2:
                    adicionarInvestigadorAoProjeto(scanner);
                    break;
                case 3:
                    removerInvestigadorDoProjeto(scanner);
                    break;
                case 4:
                    registarAtividade(scanner);
                    break;
                case 5:
                    atualizarEstadoProjeto(scanner);
                    break;
                case 6:
                    listarProjetosDoCoordenador();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    return;  // Sai do menu
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    // Criar um projeto
    private void criarProjeto(Scanner scanner) {
        System.out.println("Digite o título do projeto:");
        String titulo = scanner.nextLine();
        
        System.out.println("Digite a área do projeto (Biotecnologia, Robótica, Energia):");
        String area = scanner.nextLine();

        Projeto projeto = sistema.criarProjetoComoCoordenador(coordenadorAutenticado, titulo, area);
        if (projeto != null) {
            System.out.println("Projeto '" + titulo + "' criado com sucesso.");
        } else {
            System.out.println("Erro ao criar o projeto.");
        }
    }

    // Adicionar investigador ao projeto
    private void adicionarInvestigadorAoProjeto(Scanner scanner) {
        System.out.println("Digite o ID do projeto:");
        int idProjeto = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer de entrada
        
        System.out.println("Digite o ID do investigador:");
        int idInvestigador = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer de entrada
        
        Projeto projeto = sistema.getProjetoPorId(idProjeto);
        Investigador investigador = sistema.getInvestigadorPorId(idInvestigador);
        
        if (projeto != null && investigador != null) {
            boolean sucesso = sistema.coordenadorAdicionarInvestigadorProjeto(coordenadorAutenticado, projeto, investigador);
            if (sucesso) {
                System.out.println("Investigador adicionado ao projeto com sucesso.");
            } else {
                System.out.println("Erro ao adicionar o investigador ao projeto.");
            }
        } else {
            System.out.println("Projeto ou Investigador não encontrado.");
        }
    }

    // Remover investigador do projeto
    private void removerInvestigadorDoProjeto(Scanner scanner) {
        System.out.println("Digite o ID do projeto:");
        int idProjeto = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer de entrada
        
        System.out.println("Digite o ID do investigador:");
        int idInvestigador = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer de entrada
        
        Projeto projeto = sistema.getProjetoPorId(idProjeto);
        Investigador investigador = sistema.getInvestigadorPorId(idInvestigador);
        
        if (projeto != null && investigador != null) {
            boolean sucesso = sistema.coordenadorRemoverInvestigadorProjeto(coordenadorAutenticado, projeto, investigador);
            if (sucesso) {
                System.out.println("Investigador removido do projeto com sucesso.");
            } else {
                System.out.println("Erro ao remover o investigador do projeto.");
            }
        } else {
            System.out.println("Projeto ou Investigador não encontrado.");
        }
    }

    // Registar atividade de investigador
    private void registarAtividade(Scanner scanner) {
        System.out.println("Digite o ID do projeto:");
        int idProjeto = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer de entrada
        
        System.out.println("Digite o ID do investigador:");
        int idInvestigador = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer de entrada
        
        System.out.println("Digite o tipo de atividade:");
        String tipoAtividade = scanner.nextLine();
        
        System.out.println("Digite a data da atividade (yyyy-mm-dd):");
        String dataStr = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataStr);
        
        System.out.println("Digite a duração da atividade (em horas):");
        double duracaoHoras = scanner.nextDouble();
        
        Projeto projeto = sistema.getProjetoPorId(idProjeto);
        Investigador investigador = sistema.getInvestigadorPorId(idInvestigador);
        
        if (projeto != null && investigador != null) {
            Atividade atividade = sistema.coordenadorRegistarAtividade(coordenadorAutenticado, projeto, investigador, tipoAtividade, data, duracaoHoras);
            if (atividade != null) {
                System.out.println("Atividade registrada com sucesso.");
            } else {
                System.out.println("Erro ao registrar a atividade.");
            }
        } else {
            System.out.println("Projeto ou Investigador não encontrado.");
        }
    }

    // Atualizar estado do projeto
    private void atualizarEstadoProjeto(Scanner scanner) {
        System.out.println("Digite o ID do projeto:");
        int idProjeto = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer de entrada
        
        System.out.println("Digite o novo estado do projeto (em curso, concluído, suspenso):");
        String novoEstado = scanner.nextLine();
        
        Projeto projeto = sistema.getProjetoPorId(idProjeto);
        
        if (projeto != null) {
            boolean sucesso = sistema.coordenadorAtualizarEstadoProjeto(coordenadorAutenticado, projeto, novoEstado);
            if (sucesso) {
                System.out.println("Estado do projeto atualizado com sucesso.");
            } else {
                System.out.println("Erro ao atualizar o estado do projeto.");
            }
        } else {
            System.out.println("Projeto não encontrado.");
        }
    }

    // Listar projetos do coordenador
    private void listarProjetosDoCoordenador() {
        if (coordenadorAutenticado != null) {
            System.out.println("Projetos geridos por " + coordenadorAutenticado.getNome() + ":");
            for (Projeto p : sistema.listarProjetosDoCoordenador(coordenadorAutenticado)) {
                System.out.println("ID: " + p.getId() + " | Título: " + p.getTitulo());
            }
        } else {
            System.out.println("Nenhum coordenador autenticado.");
        }
    }
}
