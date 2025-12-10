package backend.funcionalidades;

import java.util.ArrayList;
import java.util.List;

import backend.entidades.Coordenador;
import backend.entidades.Investigador;
import backend.entidades.Laboratorio;
import backend.entidades.Projeto;

public class FuncCoordenador {

    private GestaoSistema sistema;

    public FuncCoordenador(GestaoSistema sistema) {
        this.sistema = sistema;
    }

    // ======================================================
    //  CRIAÇÃO DE PROJETOS (APENAS PELO COORDENADOR)
    // ======================================================

    public Projeto criarProjeto(Coordenador coord, String titulo, String areaCientifica) {
        if (coord == null) return null;

        Projeto p = new Projeto(titulo, areaCientifica, coord);
        sistema.adicionarProjeto(p);
        return p;
    }

    // ======================================================
    //  LISTAR PROJETOS DO COORDENADOR
    // ======================================================

    public List<Projeto> listarProjetosDoCoordenador(Coordenador coord) {
        List<Projeto> lista = new ArrayList<>();

        if (coord == null) return lista;

        for (Projeto p : sistema.listarProjetos()) {
            if (p.getCoordenador() != null && p.getCoordenador().equals(coord)) {
                lista.add(p);
            }
        }
        return lista;
    }

    // ======================================================
    //  ADICIONAR/REMOVER INVESTIGADORES DE UM PROJETO
    // ======================================================

    public boolean adicionarInvestigadorProjeto(Coordenador coord, int idProjeto, int idInvestigador) {
        Projeto p = sistema.getProjetoPorId(idProjeto);
        Investigador inv = sistema.getInvestigadorPorId(idInvestigador);

        if (coord == null || p == null || inv == null) return false;

        if (!coord.equals(p.getCoordenador())) return false;

        return sistema.associarInvestigadorProjeto(p, inv);
    }

    public boolean removerInvestigadorProjeto(Coordenador coord, int idProjeto, int idInvestigador) {
        Projeto p = sistema.getProjetoPorId(idProjeto);
        Investigador inv = sistema.getInvestigadorPorId(idInvestigador);

        if (coord == null || p == null || inv == null) return false;

        if (!coord.equals(p.getCoordenador())) return false;

        return sistema.removerInvestigadorProjeto(p, inv);
    }

    // ======================================================
    //  ASSOCIAR LABORATÓRIOS A PROJETOS
    // ======================================================

    public boolean adicionarLaboratorioProjeto(Coordenador coord, int idProjeto, int idLaboratorio) {
        Projeto p = sistema.getProjetoPorId(idProjeto);
        Laboratorio lab = sistema.getLaboratorioPorId(idLaboratorio);

        if (coord == null || p == null || lab == null) return false;

        if (!coord.equals(p.getCoordenador())) return false;

        return sistema.associarLaboratorioProjeto(p, lab);
    }

    // ======================================================
    //  ATUALIZAR ESTADO DO PROJETO
    // ======================================================

    public boolean atualizarEstadoProjeto(Coordenador coord, int idProjeto, String novoEstado) {
        Projeto p = sistema.getProjetoPorId(idProjeto);
        if (coord == null || p == null || novoEstado == null) return false;

        if (!coord.equals(p.getCoordenador())) return false;

        p.setEstadoProjeto(novoEstado);
        return true;
    }
}
