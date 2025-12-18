package backend.entidades;

public class InvestigadorBiotecnologia extends Investigador {

    private static final long serialVersionUID = 1L;

    private final String areaInvestigacao;

    public InvestigadorBiotecnologia(String nome, String email, String areaInvestigacao) {
        super(nome, email, "Biotecnologia");
        this.areaInvestigacao = areaInvestigacao;
    }

    @Override
    public String getInfoEspecifica() {
        return "Área de investigação: " + areaInvestigacao;
    }
}

