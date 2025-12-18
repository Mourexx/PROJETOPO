package backend.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Investigador implements Serializable {

    private static final long serialVersionUID = 1L;

    private static int contadorID = 1;

    private final int id;
    private String nome;
    private String email;
    private final String areaEspecializacao;

    // Estatísticas (calculadas/atualizadas pelo sistema)
    private int numeroProjetos;
    private double totalHorasDedicadas;
    private int numeroAtividades;

    // Associação
    private Laboratorio laboratorio; // pertence a um laboratório
    private final List<Projeto> projetos = new ArrayList<>();

    private static final Pattern EMAIL_RX = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public Investigador(String nome, String email, String areaEspecializacao) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome inválido.");
        if (email == null || !EMAIL_RX.matcher(email).matches()) throw new IllegalArgumentException("Email inválido.");
        if (areaEspecializacao == null || areaEspecializacao.isBlank()) throw new IllegalArgumentException("Área de especialização inválida.");

        this.id = contadorID++;
        this.nome = nome;
        this.email = email;
        this.areaEspecializacao = areaEspecializacao;

        this.numeroProjetos = 0;
        this.totalHorasDedicadas = 0.0;
        this.numeroAtividades = 0;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getAreaEspecializacao() { return areaEspecializacao; }

    public Laboratorio getLaboratorio() { return laboratorio; }
    public void setLaboratorio(Laboratorio lab) { this.laboratorio = lab; }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome inválido.");
        this.nome = nome;
    }

    public void setEmail(String email) {
        if (email == null || !EMAIL_RX.matcher(email).matches()) throw new IllegalArgumentException("Email inválido.");
        this.email = email;
    }

    public List<Projeto> getProjetos() { return new ArrayList<>(projetos); }

    public int getNumeroProjetos() { return numeroProjetos; }
    public int getNumeroAtividades() { return numeroAtividades; }
    public double getTotalHoras() { return totalHorasDedicadas; }

    // Atualizações usadas pelo sistema
    public void adicionarProjeto(Projeto p) {
        if (p != null && !projetos.contains(p)) {
            projetos.add(p);
            numeroProjetos++;
        }
    }

    public void removerProjeto(Projeto p) {
        if (p != null && projetos.remove(p)) {
            numeroProjetos = Math.max(0, numeroProjetos - 1);
        }
    }

    public void adicionarAtividade(double duracaoHoras) {
        numeroAtividades++;
        if (duracaoHoras > 0) totalHorasDedicadas += duracaoHoras;
    }

    // Autenticação simples (como tinhas; password não existe aqui no enunciado)
    public boolean autenticar(String email, String password) {
        return this.email != null && this.email.equalsIgnoreCase(email);
    }

    // Para subclasses (Biotecnologia/Energia/Robótica)
    public String getInfoEspecifica() {
        return "";
    }

    public String getNomeCompleto() {
        return nome;
    }

    @Override
    public String toString() {
        return "Investigador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", areaEspecializacao='" + areaEspecializacao + '\'' +
                ", projetos=" + numeroProjetos +
                ", atividades=" + numeroAtividades +
                ", horas=" + totalHorasDedicadas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Investigador)) return false;
        Investigador that = (Investigador) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
