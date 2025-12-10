package backend.entidades;

// IMPORTA a classe Administrador se ela estiver no mesmo package, não precisas importar
// Caso esteja noutro package, avisa-me para adaptar

public class testarAdministrador {

    public static void main(String[] args) {

        // Criar administradores
        Administrador a1 = new Administrador("João Costa", "joao@uminho.pt");
        Administrador a2 = new Administrador("Maria Silva", "maria@uminho.pt");
        Administrador a3 = new Administrador("Carlos Pereira", "carlos@uminho.pt");

        // Testar getters
        System.out.println("ID do primeiro administrador: " + a1.getIdAdministrador());
        System.out.println("Nome: " + a1.getNome());
        System.out.println("Email: " + a1.getEmail());
        System.out.println();

        // Mostrar todos
        System.out.println("---- LISTA DE ADMINISTRADORES ----");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println();

        // Testar setters
        System.out.println("A alterar dados do administrador 1...");
        a1.setNome("João Pedro Costa");
        a1.setEmail("joaopedro@uminho.pt");

        System.out.println("Novos dados:");
        System.out.println(a1);

        // Mostrar o próximo ID a ser atribuído
        System.out.println("\nPróximo ID será: " + Administrador.getProximoId());
    }
}
