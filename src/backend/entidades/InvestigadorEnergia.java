package backend.entidades;

public class InvestigadorEnergia extends Investigador {

    private static final long serialVersionUID = 1L;

    private final String fonteEnergetica;

    public InvestigadorEnergia(String nome, String email, String fonteEnergetica) {
        super(nome, email, "Energia");
        this.fonteEnergetica = fonteEnergetica;
    }

    @Override
    public String getInfoEspecifica() {
        return "Fonte energética estudada: " + fonteEnergetica;
    }
}

