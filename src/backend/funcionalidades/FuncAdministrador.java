package backend.funcionalidades;

import backend.entidades.*;
import backend.excecoes.AdministradorUnicoException;

public class FuncAdministrador {

    private GestaoSistema sistema;

    public FuncAdministrador(GestaoSistema sistema) {
        this.sistema = sistema;
    }

    // =========================
    // REGISTOS
    // =========================

    public Administrador criarAdministrador(String nome, String email, String password)
            throws AdministradorUnicoException {

        return sistema.registarAdministrador(nome, email, password);
    }

    public Coordenador criarCoordenador(String nome, String email, String password) {
        return sistema.criarCoordenador(nome, email, password);
    }

    public Investigador criarInvestigador(String nome, String email, String area) {
        return sistema.criarInvestigador(nome, email, area);
    }

    // =========================
    // LABORATÓRIOS / PROJETOS
    // =========================

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
}
