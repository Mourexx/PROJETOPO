package backend.entidades;

import java.util.ArrayList;
import java.util.List;

public class Coordenador extends Utilizador {

    private static final long serialVersionUID = 1L;

    private final List<Projeto> projetosGeridos = new ArrayList<>();

    public Coordenador(String nome, String email, String password) {
        super(nome, email, password);
    }

    public int getIdCoordenador() {
        return getId();
    }

    public int getNumeroProjetosQueGere() {
        return projetosGeridos.size();
    }

    public List<Projeto> getProjetosGeridos() {
        return new ArrayList<>(projetosGeridos);
    }

    public void adicionarProjetoGerido(Projeto p) {
        if (p != null && !projetosGeridos.contains(p)) {
            projetosGeridos.add(p);
        }
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", projetosGere=" + getNumeroProjetosQueGere() +
                '}';
    }
}

