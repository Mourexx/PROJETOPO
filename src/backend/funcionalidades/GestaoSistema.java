package backend.funcionalidades;

import java.io.Serializable;
import java.util.List;

import backend.entidades.*;
import backend.excecoes.*;
import backend.repositorios.*;

public class GestaoSistema implements Serializable {

    private static final long serialVersionUID = 1L;

    private final RepositorioAdministradores repoAdmins = new RepositorioAdministradores();
    private final RepositorioCoordenadores repoCoords = new RepositorioCoordenadores();
    private final RepositorioInvestigadores repoInvs = new RepositorioInvestigadores();
    private final RepositorioLaboratorios repoLabs = new RepositorioLaboratorios();
    private final RepositorioProjetos repoProjs = new RepositorioProjetos();

    // =========================
    // Regras comuns
    // =========================
    private void garantirEmailUnico(String email) {
        if (email == null || email.isBlank())
            throw new IllegalArgumentException("Email inválido.");

        if (repoAdmins.findByEmail(email) != null
                || repoCoords.findByEmail(email) != null
                || repoInvs.findByEmail(email) != null) {
            throw new EmailJaExisteException("Já existe um utilizador/investigador com esse email.");
        }
    }

    public boolean temAdministradores() {
        return !repoAdmins.all().isEmpty();
    }

    // =========================
    // LOGIN (MenuPrincipal)
    // =========================
    public Administrador loginAdministrador(String email, String password) {
        Administrador a = repoAdmins.findByEmail(email);
        if (a == null || !a.autenticar(email, password)) return null;
        return a;
    }

    public Coordenador loginCoordenador(String email, String password) {
        Coordenador c = repoCoords.findByEmail(email);
        if (c == null || !c.autenticar(email, password)) return null;
        return c;
    }

    public Investigador loginInvestigador(String email, String password) {
        Investigador i = repoInvs.findByEmail(email);
        if (i == null || !i.autenticar(email, password)) return null;
        return i;
    }

    // =========================
    // REGISTO (NOVO COMPORTAMENTO)
    // =========================

    /** REGISTO DE ADMINISTRADOR — SÓ PODE EXISTIR UM */
    public Administrador registarAdministrador(String nome, String email, String password) {

if (temAdministradores()) {
    throw new AdministradorUnicoException();
}



        garantirEmailUnico(email);
        Administrador admin = new Administrador(nome, email, password);
        repoAdmins.add(admin);
        return admin;
    }

    /** REGISTO DE COORDENADOR */
    public Coordenador criarCoordenador(String nome, String email, String password) {
        garantirEmailUnico(email);
        Coordenador c = new Coordenador(nome, email, password);
        repoCoords.add(c);
        return c;
    }

    /** REGISTO DE INVESTIGADOR */
    public Investigador criarInvestigador(String nome, String email, String area) {
        garantirEmailUnico(email);
        Investigador i = new Investigador(nome, email, area);
        repoInvs.add(i);
        return i;
    }

    // =========================
    // CRUD GERAL
    // =========================
    public void adicionarLaboratorio(Laboratorio l) { repoLabs.add(l); }
    public void adicionarProjeto(Projeto p) { repoProjs.add(p); }

    public boolean removerInvestigador(int id) { return repoInvs.removeById(id); }
    public boolean removerCoordenador(int id) { return repoCoords.removeById(id); }
    public boolean removerAdministrador(int id) { return repoAdmins.removeById(id); }
    public boolean removerLaboratorio(int id) { return repoLabs.removeById(id); }
    public boolean removerProjeto(int id) { return repoProjs.removeById(id); }

    public List<Administrador> listarAdministradores() { return repoAdmins.all(); }
    public List<Coordenador> listarCoordenadores() { return repoCoords.all(); }
    public List<Investigador> listarInvestigadores() { return repoInvs.all(); }
    public List<Laboratorio> listarLaboratorios() { return repoLabs.all(); }
    public List<Projeto> listarProjetos() { return repoProjs.all(); }

    public Administrador getAdministradorPorId(int id) { return repoAdmins.findById(id); }
    public Coordenador getCoordenadorPorId(int id) { return repoCoords.findById(id); }
    public Investigador getInvestigadorPorId(int id) { return repoInvs.findById(id); }
    public Laboratorio getLaboratorioPorId(int id) { return repoLabs.findById(id); }
    public Projeto getProjetoPorId(int id) { return repoProjs.findById(id); }

    // =========================
    // ASSOCIAÇÕES
    // =========================
    public boolean associarInvestigadorLaboratorio(Laboratorio lab, Investigador inv) {
        if (lab == null || inv == null) return false;
        lab.adicionarInvestigador(inv);
        return true;
    }

    public boolean associarLaboratorioProjeto(Projeto p, Laboratorio lab) {
        if (p == null || lab == null) return false;
        p.adicionarLaboratorio(lab);
        lab.adicionarProjetoAtivo();
        return true;
    }

    public boolean associarInvestigadorProjeto(Projeto p, Investigador inv) {
        if (p == null || inv == null) return false;
        p.adicionarInvestigador(inv);
        return true;
    }

    public boolean removerInvestigadorProjeto(Projeto p, Investigador inv) {
        if (p == null || inv == null) return false;
        p.removerInvestigador(inv);
        return true;
    }

    // =========================
    // ESTADO DO PROJETO
    // =========================
    public void validarEstadoProjeto(String estado) {
        if (estado == null)
            throw new EstadoProjetoInvalidoException("Estado inválido.");

        String e = estado.trim();
        if (!e.equalsIgnoreCase("Em Curso")
                && !e.equalsIgnoreCase("Concluído")
                && !e.equalsIgnoreCase("Suspenso")) {
            throw new EstadoProjetoInvalidoException(
                "Estado inválido. Use: Em Curso / Concluído / Suspenso."
            );
        }
    }

    // =========================
    // REGISTO DE ATIVIDADE
    // =========================
    public Atividade registarAtividade(
            Projeto p,
            Investigador inv,
            String tipo,
            java.util.Date data,
            double duracao) {

        if (p == null)
            throw new EntidadeNaoEncontradaException("Projeto não encontrado.");

        if (inv == null)
            throw new EntidadeNaoEncontradaException("Investigador não encontrado.");

        Atividade a = new Atividade(p, inv, tipo, data, duracao);
        p.registarAtividade(a);
        inv.adicionarAtividade(duracao);
        return a;
    }
}
