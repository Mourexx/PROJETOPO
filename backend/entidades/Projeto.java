package backend.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Projeto implements Serializable {

    private static final long serialVersionUID = 1L;

    private static int geradorIds = 1;

    private final int idProjeto;
    private String tituloProjeto;
    private String areaCientifica;
    private Coordenador coordenador;       // OBJETO, não String
    private String estadoProjeto;

    private List<Laboratorio> laboratoriosEnvolvidos;
    private List<Investigador> equipaInvestigadores;
    private List<Atividade> atividades;

    public Projeto(String tituloProjeto, String areaCientifica, String coordenador) {
        this.idProjeto = geradorIds++;
        this.tituloProjeto = tituloProjeto;
        this.areaCientifica = areaCientifica;
        this.coordenador = coordenador;
        this.estadoProjeto = "Em Curso";

        this.laboratoriosEnvolvidos = new ArrayList<>();
        this.equipaInvestigadores = new ArrayList<>();
        this.atividades = new ArrayList<>();
    }

    // ===========================
    // GETTERS
    // ===========================

    public int getIdProjeto() {
        return idProjeto;
    }

    public String getTituloProjeto() {
        return tituloProjeto;
    }

    public String getAreaCientifica() {
        return areaCientifica;
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public String getEstadoProjeto() {
        return estadoProjeto;
    }

    public List<Laboratorio> getLaboratoriosEnvolvidos() {
        return new ArrayList<>(laboratoriosEnvolvidos);
    }

    public List<Investigador> getEquipaInvestigadores() {
        return new ArrayList<>(equipaInvestigadores);
    }

    public List<Atividade> getAtividades() {
        return new ArrayList<>(atividades);
    }

    // ===========================
    // SETTERS
    // ===========================

    public void setTituloProjeto(String tituloProjeto) {
        this.tituloProjeto = tituloProjeto;
    }

    public void setAreaCientifica(String areaCientifica) {
        this.areaCientifica = areaCientifica;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    public void setEstadoProjeto(String estadoProjeto) {
        this.estadoProjeto = estadoProjeto;
    }

    // ===========================
    // ASSOCIAÇÕES
    // ===========================

    public void adicionarLaboratorio(Laboratorio lab) {
        if (!laboratoriosEnvolvidos.contains(lab)) {
            laboratoriosEnvolvidos.add(lab);
        }
    }

    public void adicionarInvestigador(Investigador inv) {
        if (!equipaInvestigadores.contains(inv)) {
            equipaInvestigadores.add(inv);
            inv.adicionarProjeto(this); // ligação invertida
        }
    }

    public void removerInvestigador(Investigador inv) {
        equipaInvestigadores.remove(inv);
    }

    public void registarAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    // ===========================
    // MÉTODOS DE ESTATÍSTICA AUTOMÁTICA
    // ===========================

    public int contarAtividadesDoInvestigador(Investigador inv) {
        int total = 0;
        for (Atividade a : atividades) {
            if (a.getInvestigadorResponsavel().equals(inv)) {
                total++;
            }
        }
        return total;
    }

    public double somarHorasAtividadesDoInvestigador(Investigador inv) {
        double total = 0;
        for (Atividade a : atividades) {
            if (a.getInvestigadorResponsavel().equals(inv)) {
                total += a.getDuracao();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "Projeto {" +
                "ID = " + idProjeto +
                ", Título = '" + tituloProjeto + '\'' +
                ", Área Científica = '" + areaCientifica + '\'' +
                ", Coordenador = " + coordenador.getNome() +
                ", Estado = '" + estadoProjeto + '\'' +
                ", Nº Investigadores = " + equipaInvestigadores.size() +
                ", Nº Laboratórios = " + laboratoriosEnvolvidos.size() +
                ", Nº Atividades = " + atividades.size() +
                "}";
    }
}

    

