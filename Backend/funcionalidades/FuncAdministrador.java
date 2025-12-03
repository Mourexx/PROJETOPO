package Backend.funcionalidades;

import java.util.List;

import Investigador.Investigador;
import Laboratorio.Laboratorio;
import Projeto.Projeto;
import Cordenador.Coordenador;
import Administrador.Administrador;

/**
 * Funcionalidades disponíveis para um Administrador (PARTE 1 — FuncAdministrador)
 * Usa o GestaoSistema para fazer o trabalho “pesado”.
 */
public class FuncAdministrador {

    private GestaoSistema sistema;

    // ==============================================
    //  CONSTRUTOR
    // ==============================================
    public FuncAdministrador(GestaoSistema sistema) {
        this.sistema = sistema;
    }

    // ==============================================
    //  CRIAÇÃO / REGISTO DE ENTIDADES
    // ==============================================

    public Administrador registarAdministrador(int id, String nome, String email) {
        return sistema.criarAdministrador(id, nome, email);
    }

    public Coordenador registarCoordenador(int id, String nome, String email) {
        return sistema.criarCoordenador(id, nome, email);
    }

    public Investigador registarInvestigador(String nome, String email, String area) {
        return sistema.criarInvestigador(nome, email, area);
    }

    public Laboratorio registarLaboratorio(String nome, String localizacao) {
        return sistema.criarLaboratorio(nome, localizacao);
    }

    public Projeto registarProjeto(String titulo, String area, int idCoordenador) {
        Coordenador coord = null;
        // procurar coordenador pelo id na lista de coordenadores
        for (Coordenador c : sistema.listarCoordenadores()) {
            if (c.getId() == idCoordenador) {
                coord = c;
                break;
            }
        }
        return sistema.criarProjeto(titulo, area, coord);
    }

    // ==============================================
    //  REMOÇÃO DE ENTIDADES
    // ==============================================

    public boolean removerInvestigador(int idInvestigador) {
        return sistema.removerInvestigador(idInvestigador);
    }

    public boolean removerCoordenador(int idCoordenador) {
        return sistema.removerCoordenador(idCoordenador);
    }

    public boolean removerLaboratorio(int idLaboratorio) {
        return sistema.removerLaboratorio(idLaboratorio);
    }

    public boolean removerProjeto(int idProjeto) {
        return sistema.removerProjeto(idProjeto);
    }

    // ==============================================
    //  ASSOCIAÇÕES / GESTÃO
    // ==============================================

    /** Associa um investigador a um laboratório, usando os IDs. */
    public boolean associarInvestigadorLaboratorio(int idLaboratorio, int idInvestigador) {
        Laboratorio lab = sistema.getLaboratorioPorId(idLaboratorio);
        Investigador inv = sistema.getInvestigadorPorId(idInvestigador);
        return sistema.adicionarInvestigadorLaboratorio(lab, inv);
    }

    /** Associa um investigador a um projeto. */
    public boolean associarInvestigadorProjeto(int idProjeto, int idInvestigador) {
        Projeto p = sistema.getProjetoPorId(idProjeto);
        Investigador inv = sistema.getInvestigadorPorId(idInvestigador);
        return sistema.adicionarInvestigadorProjeto(p, inv);
    }

    /** Remove um investigador de um projeto. */
    public boolean removerInvestigadorDeProjeto(int idProjeto, int idInvestigador) {
        Projeto p = sistema.getProjetoPorId(idProjeto);
        Investigador inv = sistema.getInvestigadorPorId(idInvestigador);
        return sistema.removerInvestigadorProjeto(p, inv);
    }

    /** Associa um laboratório a um projeto. */
    public boolean associarLaboratorioProjeto(int idProjeto, int idLaboratorio) {
        Projeto p = sistema.getProjetoPorId(idProjeto);
        Laboratorio lab = sistema.getLaboratorioPorId(idLaboratorio);
        return sistema.adicionarLaboratorioProjeto(p, lab);
    }

    /** Atualiza o estado de um projeto (ex: "Ativo", "Concluído", "Cancelado"). */
    public boolean alterarEstadoProjeto(int idProjeto, String novoEstado) {
        Projeto p = sistema.getProjetoPorId(idProjeto);
        return sistema.atualizarEstadoProjeto(p, novoEstado);
    }

    // ==============================================
    //  LISTAGENS (para o menu de admin usar)
    // ==============================================

    public List<Investigador> verTodosInvestigadores() {
        return sistema.listarInvestigadores();
    }

    public List<Coordenador> verTodosCoordenadores() {
        return sistema.listarCoordenadores();
    }

    public List<Administrador> verTodosAdministradores() {
        return sistema.listarAdministradores();
    }

    public List<Laboratorio> verTodosLaboratorios() {
        return sistema.listarLaboratorios();
    }

    public List<Projeto> verTodosProjetos() {
        return sistema.listarProjetos();
    }

    // ==============================================
    //  CONSULTAS POR ID (apoio ao front-end)
    // ==============================================

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
