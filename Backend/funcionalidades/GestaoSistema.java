
package Backend.funcionalidades;

import java.util.ArrayList;
import java.util.List;

import Investigador.Investigador;
import Laboratorio.Laboratorio;
import Projeto.Projeto;
import Cordenador.Coordenador;
import Administrador.Administrador;

public class GestaoSistema {

    // ======================================================
    //  LISTAS PRINCIPAIS DO SISTEMA
    // ======================================================
    private List<Investigador> investigadores = new ArrayList<>();
    private List<Coordenador> coordenadores = new ArrayList<>();
    private List<Administrador> administradores = new ArrayList<>();
    private List<Laboratorio> laboratorios = new ArrayList<>();
    private List<Projeto> projetos = new ArrayList<>();

    // ======================================================
    //  AUTENTICAÇÃO
    // ======================================================

    public Investigador autenticarInvestigador(String email) {
        for (Investigador inv : investigadores) {
            if (inv.getEmail().equalsIgnoreCase(email)) {
                return inv;
            }
        }
        return null;
    }

    public Coordenador autenticarCoordenador(String email) {
        for (Coordenador coord : coordenadores) {
            if (coord.getEmail().equalsIgnoreCase(email)) {
                return coord;
            }
        }
        return null;
    }

    public Administrador autenticarAdministrador(String email) {
        for (Administrador admin : administradores) {
            if (admin.getEmail().equalsIgnoreCase(email)) {
                return admin;
            }
        }
        return null;
    }

    // ======================================================
    //  VALIDAÇÕES IMPORTANTES
    // ======================================================

    private boolean emailExiste(String email) {
        for (Investigador i : investigadores) 
            if (i.getEmail().equalsIgnoreCase(email)) return true;

        for (Coordenador c : coordenadores) 
            if (c.getEmail().equalsIgnoreCase(email)) return true;

        for (Administrador a : administradores) 
            if (a.getEmail().equalsIgnoreCase(email)) return true;

        return false;
    }

    private boolean idExiste(int id) {
        for (Investigador i : investigadores) if (i.getId() == id) return true;
        for (Coordenador c : coordenadores) if (c.getId() == id) return true;
        for (Administrador a : administradores) if (a.getId() == id) return true;
        for (Laboratorio l : laboratorios) if (l.getId() == id) return true;
        for (Projeto p : projetos) if (p.getId() == id) return true;

        return false;
    }

    // ======================================================
    //  CRIAÇÃO DE ENTIDADES
    // ======================================================

    public Administrador criarAdministrador(int id, String nome, String email) {
        if (emailExiste(email) || idExiste(id)) return null;
        Administrador admin = new Administrador(id, nome, email);
        administradores.add(admin);
        return admin;
    }

    public Coordenador criarCoordenador(int id, String nome, String email) {
        if (emailExiste(email) || idExiste(id)) return null;
        Coordenador coord = new Coordenador(id, nome, email);
        coordenadores.add(coord);
        return coord;
    }

    public Investigador criarInvestigador(String nome, String email, String area) {
        Investigador inv = new Investigador(nome, email, area);
        if (emailExiste(email) || idExiste(inv.getId())) return null;

        investigadores.add(inv);
        return inv;
    }

    public Laboratorio criarLaboratorio(String nome, String localizacao) {
        Laboratorio lab = new Laboratorio(nome, localizacao);
        if (idExiste(lab.getId())) return null;

        laboratorios.add(lab);
        return lab;
    }

    public Projeto criarProjeto(String titulo, String area, Coordenador coordenador) {
        if (coordenador == null) return null;
        Projeto projeto = new Projeto(titulo, area, coordenador);
        projetos.add(projeto);
        coordenador.adicionarProjeto(projeto);
        return projeto;
    }

    // ======================================================
    //  REMOVER ENTIDADES
    // ======================================================

    public boolean removerInvestigador(int id) {
        return investigadores.removeIf(inv -> inv.getId() == id);
    }

    public boolean removerCoordenador(int id) {
        return coordenadores.removeIf(c -> c.getId() == id);
    }

    public boolean removerLaboratorio(int id) {
        return laboratorios.removeIf(l -> l.getId() == id);
    }

    public boolean removerProjeto(int id) {
        return projetos.removeIf(p -> p.getId() == id);
    }

    // ======================================================
    //  GESTÃO DE LABORATÓRIOS
    // ======================================================

    public boolean adicionarInvestigadorLaboratorio(Laboratorio lab, Investigador inv) {
        if (lab == null || inv == null) return false;
        lab.adicionarInvestigador(inv);
        return true;
    }

    // ======================================================
    //  GESTÃO DE PROJETOS
    // ======================================================

    public boolean adicionarInvestigadorProjeto(Projeto p, Investigador inv) {
        if (p == null || inv == null) return false;
        p.adicionarInvestigador(inv);
        inv.adicionarProjeto(p);
        return true;
    }

    public boolean removerInvestigadorProjeto(Projeto p, Investigador inv) {
        if (p == null || inv == null) return false;
        p.removerInvestigador(inv);
        return true;
    }

    public boolean adicionarLaboratorioProjeto(Projeto p, Laboratorio lab) {
        if (p == null || lab == null) return false;
        p.adicionarLaboratorio(lab);
        lab.adicionarProjetoAtivo();
        return true;
    }

    public boolean atualizarEstadoProjeto(Projeto p, String novoEstado) {
        if (p == null) return false;
        p.setEstadoProjeto(novoEstado);
        return true;
    }

    // ======================================================
    //  LISTAGENS GERAIS
    // ======================================================

    public List<Investigador> listarInvestigadores() {
        return new ArrayList<>(investigadores);
    }

    public List<Laboratorio> listarLaboratorios() {
        return new ArrayList<>(laboratorios);
    }

    public List<Coordenador> listarCoordenadores() {
        return new ArrayList<>(coordenadores);
    }

    public List<Administrador> listarAdministradores() {
        return new ArrayList<>(administradores);
    }

    public List<Projeto> listarProjetos() {
        return new ArrayList<>(projetos);
    }

    // ======================================================
    //  BUSCAR ENTIDADES POR ID
    // ======================================================

    public Investigador getInvestigadorPorId(int id) {
        for (Investigador i : investigadores)
            if (i.getId() == id) return i;
        return null;
    }

    public Laboratorio getLaboratorioPorId(int id) {
        for (Laboratorio l : laboratorios)
            if (l.getId() == id) return l;
        return null;
    }

    public Projeto getProjetoPorId(int id) {
        for (Projeto p : projetos)
            if (p.getId() == id) return p;
        return null;
    }
}

