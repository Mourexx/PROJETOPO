package backend.repositorios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import backend.entidades.Investigador;

public class RepositorioInvestigadores implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Investigador> lista = new ArrayList<>();

    public void add(Investigador i) { lista.add(i); }
    public boolean removeById(int id) { return lista.removeIf(i -> i.getId() == id); }
    public List<Investigador> all() { return new ArrayList<>(lista); }

    public Investigador findById(int id) {
        for (Investigador i : lista) if (i.getId() == id) return i;
        return null;
    }

    public Investigador findByEmail(String email) {
        for (Investigador i : lista) if (i.getEmail().equalsIgnoreCase(email)) return i;
        return null;
    }
}
