package backend.repositorios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import backend.entidades.Projeto;

public class RepositorioProjetos implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Projeto> lista = new ArrayList<>();

    public void add(Projeto p) { lista.add(p); }
    public boolean removeById(int id) { return lista.removeIf(p -> p.getIdProjeto() == id); }
    public List<Projeto> all() { return new ArrayList<>(lista); }

    public Projeto findById(int id) {
        for (Projeto p : lista) if (p.getIdProjeto() == id) return p;
        return null;
    }
}
