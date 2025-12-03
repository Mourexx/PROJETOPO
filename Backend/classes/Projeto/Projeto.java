package Projeto;

import java.util.ArrayList;

public class Projeto {

    private static int proximoId = 1;

    // Atributos pedidos no enunciado
    private final int idProjeto;
    private String tituloProjeto;
    private String areaCientifica;
    private ArrayList<String> laboratoriosEnvolvidos;  // temporário
    private ArrayList<String> equipaInvestigadores;    // temporário
    private String coordenador;                        // temporário
    private String estadoProjeto;

    // Construtor
    public Projeto(String tituloProjeto, String areaCientifica, String coordenador) {
        this.idProjeto = proximoId++;
        this.tituloProjeto = tituloProjeto;
        this.areaCientifica = areaCientifica;
        this.coordenador = coordenador;

        this.estadoProjeto = "Em Curso";  // valor por defeito

        this.laboratoriosEnvolvidos = new ArrayList<>();
        this.equipaInvestigadores = new ArrayList<>();
    }

    // Getters
    public int getIdProjeto() {
        return idProjeto;
    }

    public String getTituloProjeto() {
        return tituloProjeto;
    }

    public String getAreaCientifica() {
        return areaCientifica;
    }

    public ArrayList<String> getLaboratoriosEnvolvidos() {
        return laboratoriosEnvolvidos;
    }

    public ArrayList<String> getEquipaInvestigadores() {
        return equipaInvestigadores;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public String getEstadoProjeto() {
        return estadoProjeto;
    }

    // Setters
    public void setTituloProjeto(String tituloProjeto) {
        this.tituloProjeto = tituloProjeto;
    }

    public void setAreaCientifica(String areaCientifica) {
        this.areaCientifica = areaCientifica;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public void setEstadoProjeto(String estadoProjeto) {
        this.estadoProjeto = estadoProjeto;
    }

    // Métodos para listas
    public void adicionarLaboratorio(String lab) {
        laboratoriosEnvolvidos.add(lab);
    }

    public void adicionarInvestigador(String investigador) {
        equipaInvestigadores.add(investigador);
    }

    @Override
    public String toString() {
        return "\nProjeto {" +
                "\n ID = " + idProjeto +
                "\n Título = " + tituloProjeto +
                "\n Área Científica = " + areaCientifica +
                "\n Coordenador = " + coordenador +
                "\n Estado = " + estadoProjeto +
                "\n Laboratórios = " + laboratoriosEnvolvidos +
                "\n Equipa = " + equipaInvestigadores +
                "\n}";
    }

    public String getProjetoAssociado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProjetoAssociado'");
    }
}
    

