package backend.entidades;

public class testarProjeto {



    public static void main(String[] args) {

        // Criar projetos
        Projeto p1 = new Projeto("Projeto Lince", "Biotecnologia", "Dr. João Silva");
        Projeto p2 = new Projeto("Robôs Industriais", "Robótica", "Eng. Marta Ferreira");

        // Testar getters básicos
        System.out.println("ID do primeiro projeto: " + p1.getIdProjeto());
        System.out.println("Título: " + p1.getTituloProjeto());
        System.out.println("Área Científica: " + p1.getAreaCientifica());
        System.out.println("Coordenador: " + p1.getCoordenador());
        System.out.println("Estado: " + p1.getEstadoProjeto());
        System.out.println();

        // Adicionar laboratórios
        p1.adicionarLaboratorio("Laboratório de Genética");
        p1.adicionarLaboratorio("Laboratório de Ecologia");

        // Adicionar investigadores
        p1.adicionarInvestigador("Carlos Almeida");
        p1.adicionarInvestigador("Maria Santos");

        // Mostrar projeto completo
        System.out.println("---- DADOS DO PROJETO 1 ----");
        System.out.println(p1);

        // Outro projeto
        System.out.println("\n---- DADOS DO PROJETO 2 ----");
        System.out.println(p2);
    }
}

    

