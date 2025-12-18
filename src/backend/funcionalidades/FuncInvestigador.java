package backend.funcionalidades;

import java.util.ArrayList;
import java.util.List;

import backend.entidades.Atividade;
import backend.entidades.Investigador;
import backend.entidades.Laboratorio;
import backend.entidades.Projeto;

public class FuncInvestigador {

    private final GestaoSistema sistema;

    public FuncInvestigador(GestaoSistema sistema) {
        this.sistema = sistema;
    }

    public Investigador autenticar(String email, String password) {
        for (Investigador inv : sistema.listarInvestigadores()) {
            if (inv.autenticar(email, password)) {
                return inv;
            }
        }
        return null;
    }

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

    public List<Projeto> listarProjetos(Investigador inv) {
        if (inv == null) return new ArrayList<>();
        return inv.getProjetos();
    }

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

    public int obterNumeroProjetos(Investigador inv) {
        return (inv == null) ? 0 : inv.getNumeroProjetos();
    }

    public int obterNumeroAtividades(Investigador inv) {
        return (inv == null) ? 0 : inv.getNumeroAtividades();
    }

    public double obterTotalHoras(Investigador inv) {
        return (inv == null) ? 0.0 : inv.getTotalHoras();
    }

    public List<Laboratorio> listarLaboratoriosDoInvestigador(Investigador inv) {
        List<Laboratorio> labs = new ArrayList<>();
        if (inv == null) return labs;

        for (Projeto p : inv.getProjetos()) {
            for (Laboratorio lab : p.getLaboratoriosEnvolvidos()) {
                if (!labs.contains(lab)) labs.add(lab);
            }
        }
        return labs;
    }

    public boolean pertenceAoProjeto(Investigador inv, Projeto p) {
        if (inv == null || p == null) return false;
        return p.getEquipaInvestigadores().contains(inv);
    }
}
