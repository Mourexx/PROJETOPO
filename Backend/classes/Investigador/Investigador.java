package Investigador;

import Projeto.Projeto;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.Serializable;  // Importar a interface Serializable

public class Investigador implements Serializable {

    private static final long serialVersionUID = 1L;  // Versão da serialização, importante para compatibilidade entre versões

    private static int contadorID = 1;  // Contador para gerar IDs automaticamente
    private int id;
    private String nome;
    private String email;
    private String areaEspecializacao;
    private String areaInvestigacao;  // Usado para Investigador de Biotecnologia
    private String tipoSistema;       // Usado para Investigador de Robótica
    private String fonteEnergetica;   // Usado para Investigador de Energia
    private int numeroProjetos;       // Número de projetos em que o investigador participa
    private int totalHorasDedicadas;  // Total de horas dedicadas nas atividades
    private int numeroAtividades;     // Número de atividades realizadas
    private List<Projeto> projetos;  // Lista de projetos que o investigador participa

    // Construtor com validações
    public Investigador(String nome, String email, String areaEspecializacao) {
        if (!validarNome(nome)) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        if (!validarEmail(email)) {
            throw new IllegalArgumentException("Email inválido.");
        }
        if (!validarAreaEspecializacao(areaEspecializacao)) {
            throw new IllegalArgumentException("Área de especialização inválida.");
        }

        this.id = contadorID++;
        this.nome = nome;
        this.email = email;
        this.areaEspecializacao = areaEspecializacao;
        this.numeroProjetos = 0;
        this.totalHorasDedicadas = 0;
        this.numeroAtividades = 0;
        this.projetos = new ArrayList<>();
    }

    // Validação de nome (não pode ser vazio)
    private boolean validarNome(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }

    // Validação de email (formato básico de email)
    private boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Validação da área de especialização (Biotecnologia, Robótica, ou Energia)
    private boolean validarAreaEspecializacao(String area) {
        return area != null && (area.equalsIgnoreCase("Biotecnologia") ||
                area.equalsIgnoreCase("Robótica") ||
                area.equalsIgnoreCase("Energia"));
    }

    // Métodos Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getAreaEspecializacao() {
        return areaEspecializacao;
    }

    public String getAreaInvestigacao() {
        return areaInvestigacao;
    }

    public String getTipoSistema() {
        return tipoSistema;
    }

    public String getFonteEnergetica() {
        return fonteEnergetica;
    }

    public int getNumeroProjetos() {
        return numeroProjetos;
    }

    public int getTotalHorasDedicadas() {
        return totalHorasDedicadas;
    }

    public int getNumeroAtividades() {
        return numeroAtividades;
    }

    // Métodos de Estatísticas
    public void adicionarProjeto(Projeto projeto) {
        projetos.add(projeto);
        numeroProjetos++;
    }

    public void adicionarHorasDedicadas(int horas) {
        if (horas < 0) {
            throw new IllegalArgumentException("Horas não podem ser negativas.");
        }
        totalHorasDedicadas += horas;
    }

    public void adicionarAtividade() {
        numeroAtividades++;
    }

    // Editar dados pessoais
    public void editarDadosPessoais(String novoNome, String novoEmail) {
        if (!validarNome(novoNome)) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        if (!validarEmail(novoEmail)) {
            throw new IllegalArgumentException("Email inválido.");
        }
        this.nome = novoNome;
        this.email = novoEmail;
    }

    // Autenticação do Investigador (simples comparação)
    public boolean autenticar(String email, String senha) {
        // Simulando uma autenticação simples com email (no futuro pode incluir senha)
        return this.email.equals(email);
    }

    // Método para ver os projetos em que o investigador participa
    public void verProjetos() {
        if (projetos.isEmpty()) {
            System.out.println("O investigador não está participando de nenhum projeto.");
        } else {
            for (Projeto p : projetos) {
                System.out.println("Projeto: " + p.getTitulo());
            }
        }
    }

    // Exibir dados do investigador
    public void exibirDados() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Área de Especialização: " + areaEspecializacao);
        if (areaEspecializacao.equalsIgnoreCase("Biotecnologia")) {
            System.out.println("Área de Investigação: " + areaInvestigacao);
        } else if (areaEspecializacao.equalsIgnoreCase("Robótica")) {
            System.out.println("Tipo de Sistema: " + tipoSistema);
        } else if (areaEspecializacao.equalsIgnoreCase("Energia")) {
            System.out.println("Fonte Energética: " + fonteEnergetica);
        }
        System.out.println("Número de Projetos: " + numeroProjetos);
        System.out.println("Total de Horas Dedicadas: " + totalHorasDedicadas);
        System.out.println("Número de Atividades: " + numeroAtividades);
    }
}
