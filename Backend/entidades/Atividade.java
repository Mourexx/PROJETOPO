package Backend.entidades;

import java.io.Serializable;
import java.util.Date;

public class Atividade implements Serializable {

    private static final long serialVersionUID = 1L; // Adicionando serialVersionUID para controle de versão

    private int idAtividade;
    private Projeto projetoAssociado;
    private Investigador investigadorResponsavel;
    private String tipoAtividade;
    private Date data;
    private double duracao;

    public Atividade(int idAtividade, Projeto projetoAssociado, Investigador investigadorResponsavel,
                     String tipoAtividade, Date data, double duracao) {
        this.idAtividade = idAtividade;
        this.projetoAssociado = projetoAssociado;
        this.investigadorResponsavel = investigadorResponsavel;
        this.tipoAtividade = tipoAtividade;
        this.data = data;
        this.duracao = duracao;
    }

    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }

    public Projeto getProjetoAssociado() {
        return projetoAssociado;
    }

    public void setProjetoAssociado(Projeto projetoAssociado) {
        this.projetoAssociado = projetoAssociado;
    }

    public Investigador getInvestigadorResponsavel() {
        return investigadorResponsavel;
    }

    public void setInvestigadorResponsavel(Investigador investigadorResponsavel) {
        this.investigadorResponsavel = investigadorResponsavel;
    }

    public String getTipoAtividade() {
        return tipoAtividade;
    }

    public void setTipoAtividade(String tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public void exibirDetalhes() {
        System.out.println("Atividade ID: " + idAtividade);
        System.out.println("Projeto: " + projetoAssociado.getTituloProjeto());
        System.out.println("Investigador: " + investigadorResponsavel.getNomeCompleto());
        System.out.println("Tipo de Atividade: " + tipoAtividade);
        System.out.println("Data: " + data.toString());
        System.out.println("Duração: " + duracao + " horas");
    }
}
