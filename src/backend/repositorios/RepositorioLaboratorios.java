

package backend.repositorios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import backend.entidades.Laboratorio;

public class RepositorioLaboratorios implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Laboratorio> lista = new ArrayList<>();

    public void add(Laboratorio l) { lista.add(l); }
    public boolean removeById(int id) { return lista.removeIf(l -> l.getId() == id); }
    public List<Laboratorio> all() { return new ArrayList<>(lista); }

    public Laboratorio findById(int id) {
        for (Laboratorio l : lista) if (l.getId() == id) return l;
        return null;
    }
}
