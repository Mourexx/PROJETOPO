package backend.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Projeto implements Serializable {

    private static final long serialVersionUID = 1L;

    private static int geradorIds = 1;

    private final int idProjeto;
    private String tituloProjeto;
    private String areaCientifica;
    private Coordenador coordenador;
    private String estadoProjeto; // "Em Curso", "Concluído", "Suspenso"

    private final List<Laboratorio> laboratoriosEnvolvidos = new ArrayList<>();
    private final List<Investigador> equipaInvestigadores = new ArrayList<>();
    private final List<Atividade> atividades = new ArrayList<>();

    public Projeto(String tituloProjeto, String areaCientifica, Coordenador coordenador) {
        this.idProjeto = geradorIds++;
        this.tituloProjeto = tituloProjeto;
        this.areaCientifica = areaCientifica;
        this.coordenador = coordenador;
        this.estadoProjeto = "Em Curso";
    }

    public int getIdProjeto() { return idProjeto; }
    public String getTituloProjeto() { return tituloProjeto; }
    public String getAreaCientifica() { return areaCientifica; }
    public Coordenador getCoordenador() { return coordenador; }
    public String getEstadoProjeto() { return estadoProjeto; }

    public List<Laboratorio> getLaboratoriosEnvolvidos() { return new ArrayList<>(laboratoriosEnvolvidos); }
    public List<Investigador> getEquipaInvestigadores() { return new ArrayList<>(equipaInvestigadores); }
    public List<Atividade> getAtividades() { return new ArrayList<>(atividades); }

    public void setTituloProjeto(String tituloProjeto) { this.tituloProjeto = tituloProjeto; }
    public void setAreaCientifica(String areaCientifica) { this.areaCientifica = areaCientifica; }
    public void setCoordenador(Coordenador coordenador) { this.coordenador = coordenador; }
    public void setEstadoProjeto(String estadoProjeto) { this.estadoProjeto = estadoProjeto; }

    public void adicionarLaboratorio(Laboratorio lab) {
        if (lab != null && !laboratoriosEnvolvidos.contains(lab)) {
            laboratoriosEnvolvidos.add(lab);
        }
    }

    public void adicionarInvestigador(Investigador inv) {
        if (inv != null && !equipaInvestigadores.contains(inv)) {
            equipaInvestigadores.add(inv);
            inv.adicionarProjeto(this);
        }
    }

    public void removerInvestigador(Investigador inv) {
        if (inv != null && equipaInvestigadores.remove(inv)) {
            inv.removerProjeto(this);
        }
    }

    public void registarAtividade(Atividade atividade) {
        if (atividade != null) atividades.add(atividade);
    }

    @Override
    public String toString() {
        String nomeCoord = (coordenador == null) ? "N/A" : coordenador.getNome();
        return "Projeto{" +
                "id=" + idProjeto +
                ", titulo='" + tituloProjeto + '\'' +
                ", area='" + areaCientifica + '\'' +
                ", coordenador='" + nomeCoord + '\'' +
                ", estado='" + estadoProjeto + '\'' +
                ", labs=" + laboratoriosEnvolvidos.size() +
                ", equipa=" + equipaInvestigadores.size() +
                ", atividades=" + atividades.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Projeto)) return false;
        Projeto projeto = (Projeto) o;
        return idProjeto == projeto.idProjeto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProjeto);
    }
}

