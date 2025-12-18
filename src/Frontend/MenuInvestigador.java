package Frontend;

import java.util.Scanner;

import backend.entidades.Investigador;
import backend.entidades.Projeto;
import backend.funcionalidades.FuncInvestigador;
import backend.funcionalidades.GestaoSistema;

public class MenuInvestigador {

    private GestaoSistema sistema;
    private FuncInvestigador funcInv;
    private Investigador investigador;
    private Scanner scanner = new Scanner(System.in);

    // ✅ CONSTRUTOR ALINHADO COM MenuPrincipal
    public MenuInvestigador(GestaoSistema sistema, Investigador investigador) {
        this.sistema = sistema;
        this.investigador = investigador;
        this.funcInv = new FuncInvestigador(sistema);
    }

    public void mostrar() {

        while (true) {
            System.out.println("\n===== MENU INVESTIGADOR =====");
            System.out.println("1. Ver projetos");
            System.out.println("2. Ver estatísticas");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            String op = scanner.nextLine();

            switch (op) {
                case "1": listarProjetos(); break;
                case "2": verEstatisticas(); break;
                case "0": return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    private void listarProjetos() {
        for (Projeto p : funcInv.listarProjetos(investigador)) {
            System.out.println(p);
        }
    }

    private void verEstatisticas() {
        System.out.println("Nº projetos: " + funcInv.obterNumeroProjetos(investigador));
        System.out.println("Nº atividades: " + funcInv.obterNumeroAtividades(investigador));
        System.out.println("Total horas: " + funcInv.obterTotalHoras(investigador));
    }
}
