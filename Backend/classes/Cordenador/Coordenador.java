package Cordenador;

import java.io.Serializable;  // Importar a interface Serializable

public class Coordenador implements Serializable {

    private static final long serialVersionUID = 1L;  // Versão da serialização, importante para compatibilidade entre versões

    private int idCoordenador;      
    private String nomeCompleto;    
    private String email;            
    private int numProjetosGere;     

    // Construtor
    public Coordenador(int idCoordenador, String nomeCompleto, String email) {
        this.idCoordenador = idCoordenador;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.numProjetosGere = 0;
    }

    // Getters e Setters
    public int getIdCoordenador() {
        return idCoordenador;
    }

    public void setIdCoordenado
