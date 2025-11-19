package Laboratorio;

import java.util.ArrayList;
import java.util.List;
import Investigador.Investigador;

public class Laboratorio {
    private static int contadorID = 1;  // Contador para gerar IDs automaticamente
    private int id;
    private String nome;
    private String localizacao;
    private List<Investigador> investigadores;  // Lista de investigadores que pertencem ao laboratório
    private int numeroProjetosAtivos;  // Número de projetos em que o laboratório está envolvido

    // Construtor com validações
    public Laboratorio(String nome, String localizacao) {
        if (!validarNome(nome)) {
            throw new IllegalArgumentException("Nome do laboratório inválido.");
        }
        if (!validarLocalizacao(localizacao)) {
            throw new IllegalArgumentException("Localização inválida.");
        }

        this.id = contadorID++;
        this.nome = nome;
        this.localizacao = localizacao;
        this.investigadores = new ArrayList<>();
        this.numeroProjetosAtivos = 0;
    }

    // Validação de nome (não pode ser vazio)
    private boolean validarNome(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }

    // Validação de localização (não pode ser vazio)
    private boolean validarLocalizacao(String localizacao) {
        return localizacao != null && !localizacao.trim().isEmpty();
    }

    // Métodos Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }

    public int getNumeroProjetosAtivos() {
        return numeroProjetosAtivos;
    }

    // Métodos Setters
    public void setNome(String nome) {
        if (!validarNome(nome)) {
            throw new IllegalArgumentException("Nome do laboratório inválido.");
        }
        this.nome = nome;
    }

    public void setLocalizacao(String localizacao) {
        if (!validarLocalizacao(localizacao)) {
            throw new IllegalArgumentException("Localização inválida.");
        }
        this.localizacao = localizacao;
    }

    // Adiciona um investigador ao laboratório
    public void adicionarInvestigador(Investigador investigador) {
        if (investigador == null) {
            throw new IllegalArgumentException("Investigador inválido.");
        }
        investigadores.add(investigador);
    }

    // Remove um investigador do laboratório
    public void removerInvestigador(Investigador investigador) {
        if (investigador == null) {
            throw new IllegalArgumentException("Investigador inválido.");
        }
        investigadores.remove(investigador);
    }

    // Adiciona um projeto ativo ao laboratório
    public void adicionarProjetoAtivo() {
        numeroProjetosAtivos++;
    }

    // Remove um projeto ativo do laboratório
    public void removerProjetoAtivo() {
        if (numeroProjetosAtivos > 0) {
            numeroProjetosAtivos--;
        } else {
            throw new IllegalStateException("Não há projetos ativos para remover.");
        }
    }

    // Exibir os dados do laboratório
    public void exibirDados() {
        System.out.println("ID do Laboratório: " + id);
        System.out.println("Nome do Laboratório: " + nome);
        System.out.println("Localização: " + localizacao);
        System.out.println("Número de Projetos Ativos: " + numeroProjetosAtivos);
        System.out.println("Investigadores no Laboratório:");
        if (investigadores.isEmpty()) {
            System.out.println("Nenhum investigador registrado.");
        } else {
            for (Investigador i : investigadores) {
                System.out.println("- " + i.getNome());
            }
        }
    }
}
