package backend.entidades;

import java.util.ArrayList;
import java.util.List;


public class Laboratorio {

    private static int contadorID = 1;  // Geração automática de IDs
    private int id;
    private String nome;
    private String localizacao;
    private List<Investigador> investigadores;  
    private int numeroProjetosAtivos;

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

    // Validação de nome
    private boolean validarNome(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }

    // Validação de localização
    private boolean validarLocalizacao(String localizacao) {
        return localizacao != null && !localizacao.trim().isEmpty();
    }

    // Getters
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
        return new ArrayList<>(investigadores);
    }

    public int getNumeroProjetosAtivos() {
        return numeroProjetosAtivos;
    }

    // Setters
    public void setNome(String nome) {
        if (!validarNome(nome)) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        this.nome = nome;
    }

    public void setLocalizacao(String localizacao) {
        if (!validarLocalizacao(localizacao)) {
            throw new IllegalArgumentException("Localização inválida.");
        }
        this.localizacao = localizacao;
    }

    // Adicionar investigador ao laboratório
    public void adicionarInvestigador(Investigador investigador) {
        if (investigador == null) {
            throw new IllegalArgumentException("Investigador inválido.");
        }
        investigadores.add(investigador);
    }

    // Remover investigador
    public void removerInvestigador(Investigador investigador) {
        if (investigador == null) {
            throw new IllegalArgumentException("Investigador inválido.");
        }
        investigadores.remove(investigador);
    }

    // Incrementar projetos ativos
    public void adicionarProjetoAtivo() {
        numeroProjetosAtivos++;
    }

    // Remover projeto ativo
    public void removerProjetoAtivo() {
        if (numeroProjetosAtivos > 0) {
            numeroProjetosAtivos--;
        } else {
            throw new IllegalStateException("Nenhum projeto ativo para remover.");
        }
    }

    // Exibir dados do laboratório
    public void exibirDados() {
        System.out.println("ID do Laboratório: " + id);
        System.out.println("Nome do Laboratório: " + nome);
        System.out.println("Localização: " + localizacao);
        System.out.println("Projetos Ativos: " + numeroProjetosAtivos);
        System.out.println("Investigadores:");

        if (investigadores.isEmpty()) {
            System.out.println("Nenhum investigador registado.");
        } else {
            for (Investigador inv : investigadores) {
             System.out.println("- " + inv.getNome());
            
            

            }
        }
    }
}
