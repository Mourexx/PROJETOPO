    // ======================================================
    //  FUNCIONALIDADES ESPECÍFICAS DO COORDENADOR
    // ======================================================

    /**
     * Criar um projeto estando autenticado como coordenador.
     */
    public Projeto criarProjetoComoCoordenador(Coordenador coordenador, String titulo, String area) {
        if (coordenador == null) return null;
        if (!coordenadores.contains(coordenador)) return null;

        return criarProjeto(titulo, area, coordenador);
    }

    /**
     * Listar todos os projetos geridos por um determinado coordenador.
     */
    public List<Projeto> listarProjetosDoCoordenador(Coordenador coordenador) {
        List<Projeto> resultado = new ArrayList<>();
        if (coordenador == null) return resultado;

        for (Projeto p : projetos) {
            if (p.getCoordenador() != null && p.getCoordenador().equals(coordenador)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    /**
     * Adicionar um investigador a um projeto, garantindo que
     * o coordenador passado é o responsável desse projeto.
     */
    public boolean coordenadorAdicionarInvestigadorProjeto(Coordenador coordenador, Projeto p, Investigador inv) {
        if (coordenador == null || p == null || inv == null) return false;

        // Coordenador tem de ser o responsável pelo projeto
        if (p.getCoordenador() == null || !p.getCoordenador().equals(coordenador)) {
            return false;
        }

        // Evitar duplicados (se o Projeto tiver este método)
        if (p.getInvestigadores() != null && p.getInvestigadores().contains(inv)) {
            return false;
        }

        return adicionarInvestigadorProjeto(p, inv);
    }

    /**
     * Remover um investigador de um projeto, garantindo que
     * o coordenador passado é o responsável desse projeto.
     */
    public boolean coordenadorRemoverInvestigadorProjeto(Coordenador coordenador, Projeto p, Investigador inv) {
        if (coordenador == null || p == null || inv == null) return false;

        if (p.getCoordenador() == null || !p.getCoordenador().equals(coordenador)) {
            return false;
        }

        return removerInvestigadorProjeto(p, inv);
    }

    /**
     * Adicionar um laboratório a um projeto, pelo coordenador responsável.
     */
    public boolean coordenadorAdicionarLaboratorioProjeto(Coordenador coordenador, Projeto p, Laboratorio lab) {
        if (coordenador == null || p == null || lab == null) return false;

        if (p.getCoordenador() == null || !p.getCoordenador().equals(coordenador)) {
            return false;
        }

        return adicionarLaboratorioProjeto(p, lab);
    }

    /**
     * Atualizar o estado de um projeto (em curso, concluído, suspenso),
     * apenas se o coordenador passado for o coordenador desse projeto.
     */
    public boolean coordenadorAtualizarEstadoProjeto(Coordenador coordenador, Projeto p, String novoEstado) {
        if (coordenador == null || p == null || novoEstado == null) return false;

        if (p.getCoordenador() == null || !p.getCoordenador().equals(coordenador)) {
            return false;
        }

        return atualizarEstadoProjeto(p, novoEstado);
    }
