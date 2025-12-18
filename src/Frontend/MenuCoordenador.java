package Frontend;

import java.util.Scanner;

import backend.entidades.Coordenador;
import backend.entidades.Projeto;
import backend.funcionalidades.FuncCoordenador;
import backend.funcionalidades.GestaoSistema;

public class MenuCoordenador {

    private GestaoSistema sistema;
    private FuncCoordenador funcCoord;
    private Coordenador coordenador;
    private Scanner scanner = new Scanner(System.in);

    // ✅ CONSTRUTOR ALINHADO COM MenuPrincipal
    public MenuCoordenador(GestaoSistema sistema, Coordenador coordenador) {
        this.sistema = sistema;
        this.coordenador = coordenador;
        this.funcCoord = new FuncCoordenador(sistema);
    }

    public void mostrar() {

        while (true) {
            System.out.println("\n===== MENU COORDENADOR =====");
            System.out.println("1. Criar Projeto");
            System.out.println("2. Listar Projetos");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            String op = scanner.nextLine();

            switch (op) {
                case "1": criarProjeto(); break;
                case "2": listarProjetos(); break;
                case "0": return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    private void criarProjeto() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Área científica: ");
        String area = scanner.nextLine();

        funcCoord.criarProjeto(coordenador, titulo, area);
        System.out.println("Projeto criado com sucesso.");
    }

    private void listarProjetos() {
        for (Projeto p : funcCoord.listarProjetosDoCoordenador(coordenador)) {
            System.out.println(p);
        }
    }
}
