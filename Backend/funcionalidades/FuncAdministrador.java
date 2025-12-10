package backend.funcionalidades;

import java.util.List;

import backend.entidades.Administrador;
import backend.entidades.Coordenador;
import backend.entidades.Investigador;
import backend.entidades.Laboratorio;
import backend.entidades.Projeto;

public class FuncAdministrador {

    private GestaoSistema sistema;

    public FuncAdministrador(GestaoSistema sistema) {
        this.sistema = sistema;
    }

    // ============================================================
    // CRIAÇÃO DE UTILIZADORES E ENTIDADES
    // ============================================================

    public Administrador criarAdministrador(String nome, String email, String password) {
        Administrador admin = new Administrador(nome, email, password);
        sistema.adicionarAdministrador(admin);
        return admin;
    }

    public Coordenador criarCoordenador(String nome, String email, String password) {
        Coordenador coord = new Coordenador(nome, email, password);
        sistema.adicionarCoordenador(coord);
        return coord;
    }

    public Laboratorio criarLaboratorio(String nome, String localizacao) {
        Laboratorio lab = new Laboratorio(nome, localizacao);
        sistema.adicionarLaboratorio(lab);
        return lab;
    }

    public Projeto criarProjeto(String titulo, String area, int idCoordenador) {
        Coordenador coord = sistema.getCoordenadorPorId(idCoordenador);
        if (coord == null) return null;

        Projeto p = new Projeto(titulo, area, coord);
        sistema.adicionarProjeto(p);
        return p;
    }

    // ============================================================
    // REMOÇÕES
    // ============================================================

    public boolean removerLaboratorio(int id) {
        return sistema.removerLaboratorio(id);
    }

    public boolean removerCoordenador(int id) {
        return sistema.removerCoordenador(id);
    }

    public boolean removerProjeto(int id) {
        return sistema.removerProjeto(id);
    }

    public boolean removerInvestigador(int id) {
        return sistema.removerInvestigador(id);
    }

    // ============================================================
    // ASSOCIAÇÕES
    // ============================================================

    public boolean associarInvestigadorLaboratorio(int idLab, int idInv) {
        Laboratorio lab = sistema.getLaboratorioPorId(idLab);
        Investigador inv = sistema.getInvestigadorPorId(idInv);
        return sistema.associarInvestigadorLaboratorio(lab, inv);
    }

    public boolean associarInvestigadorProjeto(int idProjeto, int idInv) {
        Projeto p = sistema.getProjetoPorId(idProjeto);
        Investigador inv = sistema.getInvestigadorPorId(idInv);
        return sistema.associarInvestigadorProjeto(p, inv);
    }

    public boolean associarLaboratorioProjeto(int idProjeto, int idLab) {
        Projeto p = sistema.getProjetoPorId(idProjeto);
        Laboratorio lab = sistema.getLaboratorioPorId(idLab);
        return sistema.associarLaboratorioProjeto(p, lab);
    }

    public boolean alterarEstadoProjeto(int idProjeto, String novoEstado) {
        Projeto p = sistema.getProjetoPorId(idProjeto);
        if (p == null) return false;

        p.setEstadoProjeto(novoEstado);
        return true;
    }

    // ============================================================
    // LISTAGENS
    // ============================================================

    public List<Administrador> listarAdministradores() {
        return sistema.listarAdministradores();
    }

    public List<Coordenador> listarCoordenadores() {
        return sistema.listarCoordenadores();
    }

    public List<Laboratorio> listarLaboratorios() {
        return sistema.listarLaboratorios();
    }

    public List<Projeto> listarProjetos() {
        return sistema.listarProjetos();
    }

    public List<Investigador> listarInvestigadores() {
        return sistema.listarInvestigadores();
    }

    // ============================================================
    // CONSULTAS
    // ============================================================

    public Investigador procurarInvestigadorPorId(int id) {
        return sistema.getInvestigadorPorId(id);
    }

    public Laboratorio procurarLaboratorioPorId(int id) {
        return sistema.getLaboratorioPorId(id);
    }

    public Projeto procurarProjetoPorId(int id) {
        return sistema.getProjetoPorId(id);
    }
}
