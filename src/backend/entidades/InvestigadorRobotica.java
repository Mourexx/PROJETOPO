package backend.entidades;

public class InvestigadorRobotica extends Investigador {

    private static final long serialVersionUID = 1L;

    private final String tipoSistema;

    public InvestigadorRobotica(String nome, String email, String tipoSistema) {
        super(nome, email, "Robótica");
        this.tipoSistema = tipoSistema;
    }

    @Override
    public String getInfoEspecifica() {
        return "Tipo de sistema trabalhado: " + tipoSistema;
    }
}



