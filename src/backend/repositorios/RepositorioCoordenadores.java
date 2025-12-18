

package backend.repositorios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import backend.entidades.Coordenador;

public class RepositorioCoordenadores implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Coordenador> lista = new ArrayList<>();

    public void add(Coordenador c) { lista.add(c); }
    public boolean removeById(int id) { return lista.removeIf(c -> c.getIdCoordenador() == id); }
    public List<Coordenador> all() { return new ArrayList<>(lista); }

    public Coordenador findById(int id) {
        for (Coordenador c : lista) if (c.getIdCoordenador() == id) return c;
        return null;
    }

    public Coordenador findByEmail(String email) {
        for (Coordenador c : lista) if (c.getEmail().equalsIgnoreCase(email)) return c;
        return null;
    }
}
