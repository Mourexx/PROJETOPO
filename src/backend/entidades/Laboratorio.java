package backend.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Laboratorio implements Serializable {

    private static final long serialVersionUID = 1L;

    private static int contadorID = 1;

    private final int id;
    private String nome;
    private String localizacao;
    private final List<Investigador> investigadores = new ArrayList<>();
    private int numeroProjetosAtivos;

    public Laboratorio(String nome, String localizacao) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome do laboratório inválido.");
        if (localizacao == null || localizacao.isBlank()) throw new IllegalArgumentException("Localização inválida.");

        this.id = contadorID++;
        this.nome = nome;
        this.localizacao = localizacao;
        this.numeroProjetosAtivos = 0;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getLocalizacao() { return localizacao; }
    public int getNumeroProjetosAtivos() { return numeroProjetosAtivos; }

    public List<Investigador> getInvestigadores() {
        return new ArrayList<>(investigadores);
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome inválido.");
        this.nome = nome;
    }

    public void setLocalizacao(String localizacao) {
        if (localizacao == null || localizacao.isBlank()) throw new IllegalArgumentException("Localização inválida.");
        this.localizacao = localizacao;
    }

    public void adicionarInvestigador(Investigador investigador) {
        if (investigador == null) throw new IllegalArgumentException("Investigador inválido.");
        if (!investigadores.contains(investigador)) {
            investigadores.add(investigador);
            investigador.setLaboratorio(this);
        }
    }

    public void removerInvestigador(Investigador investigador) {
        if (investigador == null) throw new IllegalArgumentException("Investigador inválido.");
        if (investigadores.remove(investigador)) {
            investigador.setLaboratorio(null);
        }
    }

    public void adicionarProjetoAtivo() {
        numeroProjetosAtivos++;
    }

    public void removerProjetoAtivo() {
        if (numeroProjetosAtivos <= 0) throw new IllegalStateException("Nenhum projeto ativo para remover.");
        numeroProjetosAtivos--;
    }

    @Override
    public String toString() {
        return "Laboratorio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", investigadores=" + investigadores.size() +
                ", projetosAtivos=" + numeroProjetosAtivos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laboratorio)) return false;
        Laboratorio that = (Laboratorio) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
