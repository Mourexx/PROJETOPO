package backend.funcionalidades;

import java.util.ArrayList;
import java.util.List;

import backend.entidades.Atividade;
import backend.entidades.Investigador;
import backend.entidades.Projeto;
import backend.entidades.Laboratorio;

public class FuncInvestigador {

    private GestaoSistema sistema;

    public FuncInvestigador(GestaoSistema sistema) {
        this.sistema = sistema;
    }

    // ==============================================================
    //  AUTENTICAÇÃO DO INVESTIGADOR
    // ==============================================================

    public Investigador autenticar(String email, String password) {
        for (Investigador inv : sistema.listarInvestigadores()) {
            if (inv.autenticar(email, password)) {
                return inv;
            }
        }
        return null; 
    }

    // ==============================================================
    //  PERFIL DO INVESTIGADOR
    // ==============================================================

    public boolean editarNome(Investigador inv, String novoNome) {
        if (inv == null || novoNome == null || novoNome.isBlank()) return false;
        inv.setNome(novoNome);
        return true;
    }

    public boolean editarEmail(Investigador inv, String novoEmail) {
        if (inv == null || novoEmail == null || novoEmail.isBlank()) return false;
        inv.setEmail(novoEmail);
        return true;
    }

    // ==============================================================
    //  CONSULTAS DE PROJETOS
    // ==============================================================

    /** Lista os projetos em que o investigador participa */
    public int listarProjetos(Investigador inv) {
        if (inv == null) return new ArrayList<>();
        return inv.getNumeroProjetos();
    }

    /** Lista as atividades do investigador em todos os projetos */
    public List<Atividade> listarAtividadesDoInvestigador(Investigador inv) {
        List<Atividade> resultado = new ArrayList<>();

        if (inv == null) return resultado;

        for (Projeto p : sistema.listarProjetos()) {
            for (Atividade a : p.getAtividades()) {
                if (a.getInvestigadorResponsavel().equals(inv)) {
                    resultado.add(a);
                }
            }
        }

        return resultado;
    }

    // ==============================================================
    //  ESTATÍSTICAS DO INVESTIGADOR
    // ==============================================================

    public int obterNumeroProjetos(Investigador inv) {
        if (inv == null) return 0;
        return inv.getNumeroProjetos();
    }

    public int obterNumeroAtividades(Investigador inv) {
        if (inv == null) return 0;
        return inv.getNumeroAtividades();
    }

    public double obterTotalHoras(Investigador inv) {
        if (inv == null) return 0;
        return inv.getTotalHoras();
    }

    // ==============================================================
    //  CONSULTAR LABORATÓRIOS ASSOCIADOS AOS SEUS PROJETOS
    // ==============================================================

    public List<Laboratorio> listarLaboratoriosDoInvestigador(Investigador inv) {
        List<Laboratorio> labs = new ArrayList<>();

        if (inv == null) return labs;

        for (Projeto p : inv.getNumeroProjetos()) {
            for (Laboratorio lab : p.getLaboratoriosEnvolvidos()) {
                if (!labs.contains(lab)) {
                    labs.add(lab);
                }
            }
        }

        return labs;
    }

    // ==============================================================
    //  VERIFICAR SE INVESTIGADOR PERTENCE A PROJETO
    // ==============================================================

    public boolean pertenceAoProjeto(Investigador inv, Projeto p) {
        if (inv == null || p == null) return false;
        return p.getEquipaInvestigadores().contains(inv);
    }
}


