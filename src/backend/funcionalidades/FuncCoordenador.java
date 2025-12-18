package backend.funcionalidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import backend.entidades.*;
import backend.excecoes.*;

public class FuncCoordenador {

    private final GestaoSistema sistema;

    public FuncCoordenador(GestaoSistema sistema) {
        this.sistema = sistema;
    }

    public Projeto criarProjeto(Coordenador coord, String titulo, String areaCientifica) {
        if (coord == null) throw new OperacaoNaoPermitidaException("Coordenador inválido.");

        Projeto p = new Projeto(titulo, areaCientifica, coord);
        sistema.adicionarProjeto(p);
        coord.adicionarProjetoGerido(p);
        return p;
    }

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

    public boolean adicionarLaboratorioProjeto(Coordenador coord, int idProjeto, int idLaboratorio) {
        Projeto p = sistema.getProjetoPorId(idProjeto);
        Laboratorio lab = sistema.getLaboratorioPorId(idLaboratorio);

        if (coord == null || p == null || lab == null) return false;
        if (!coord.equals(p.getCoordenador())) return false;

        return sistema.associarLaboratorioProjeto(p, lab);
    }

    public boolean atualizarEstadoProjeto(Coordenador coord, int idProjeto, String novoEstado) {
        Projeto p = sistema.getProjetoPorId(idProjeto);
        if (coord == null || p == null) return false;
        if (!coord.equals(p.getCoordenador())) return false;

        sistema.validarEstadoProjeto(novoEstado);
        p.setEstadoProjeto(novoEstado);
        return true;
    }

    public Atividade registarAtividade(Coordenador coord, int idProjeto, int idInvestigador, String tipo, Date data, double duracao) {
        Projeto p = sistema.getProjetoPorId(idProjeto);
        if (p == null) throw new EntidadeNaoEncontradaException("Projeto não encontrado.");
        if (!coord.equals(p.getCoordenador())) throw new OperacaoNaoPermitidaException("Não autorizado.");

        Investigador inv = sistema.getInvestigadorPorId(idInvestigador);
        if (inv == null) throw new EntidadeNaoEncontradaException("Investigador não encontrado.");

        return sistema.registarAtividade(p, inv, tipo, data, duracao);
    }
}
