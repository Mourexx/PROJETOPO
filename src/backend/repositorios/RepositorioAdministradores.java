package backend.repositorios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import backend.entidades.Administrador;

public class RepositorioAdministradores implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Administrador> lista = new ArrayList<>();

    public void add(Administrador a) { lista.add(a); }
    public boolean removeById(int id) { return lista.removeIf(a -> a.getIdAdministrador() == id); }
    public List<Administrador> all() { return new ArrayList<>(lista); }

    public Administrador findById(int id) {
        for (Administrador a : lista) if (a.getIdAdministrador() == id) return a;
        return null;
    }

    public Administrador findByEmail(String email) {
        for (Administrador a : lista) if (a.getEmail().equalsIgnoreCase(email)) return a;
        return null;
    }
}
