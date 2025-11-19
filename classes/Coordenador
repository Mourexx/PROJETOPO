public class Coordenador {

    
    private int idCoordenador;      
    private String nomeCompleto;    
    private String email;            
    private int numProjetosGere;     

   
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

    public void setIdCoordenador(int idCoordenador) {
        this.idCoordenador = idCoordenador;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumProjetosGere() {
        return numProjetosGere;
    }

    public void setNumProjetosGere(int numProjetosGere) {
        this.numProjetosGere = numProjetosGere;
    }

   
    public void autenticar() {
        
        System.out.println("Autenticação realizada com sucesso para o coordenador: " + nomeCompleto);
    }

    public void criarProjeto() {
       
        System.out.println("Projeto criado pelo coordenador: " + nomeCompleto);
        numProjetosGere++; 
    }

    public void adicionarInvestigadorAoProjeto() {
        
        System.out.println("Investigador adicionado ao projeto.");
    }

    public void removerInvestigadorDoProjeto() {
        
        System.out.println("Investigador removido do projeto.");
    }

    public void registarAtividade() {
       
        System.out.println("Atividade registada com sucesso.");
    }

    public void acompanharProgresso() {
      
        System.out.println("Progresso do projeto monitorado.");
    }
}
