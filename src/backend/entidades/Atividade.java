package backend.entidades;

import java.io.Serializable;
import java.util.Date;

public class Atividade implements Serializable {

    private static final long serialVersionUID = 1L;

    private static int geradorId = 1;

    private final int idAtividade;
    private final Projeto projetoAssociado;
    private final Investigador investigadorResponsavel;
    private final String tipoAtividade;
    private final Date data;
    private final double duracao;

    public Atividade(Projeto projetoAssociado,
                     Investigador investigadorResponsavel,
                     String tipoAtividade, Date data, double duracao) {
        this.idAtividade = geradorId++;
        this.projetoAssociado = projetoAssociado;
        this.investigadorResponsavel = investigadorResponsavel;
        this.tipoAtividade = tipoAtividade;
        this.data = data;
        this.duracao = duracao;
    }

    public int getIdAtividade() { return idAtividade; }
    public Projeto getProjetoAssociado() { return projetoAssociado; }
    public Investigador getInvestigadorResponsavel() { return investigadorResponsavel; }
    public String getTipoAtividade() { return tipoAtividade; }
    public Date getData() { return data; }
    public double getDuracao() { return duracao; }

    @Override
    public String toString() {
        String proj = (projetoAssociado == null) ? "N/A" : projetoAssociado.getTituloProjeto();
        String inv = (investigadorResponsavel == null) ? "N/A" : investigadorResponsavel.getNome();
        return "Atividade{" +
                "id=" + idAtividade +
                ", projeto='" + proj + '\'' +
                ", investigador='" + inv + '\'' +
                ", tipo='" + tipoAtividade + '\'' +
                ", data=" + data +
                ", duracao=" + duracao +
                '}';
    }
}
