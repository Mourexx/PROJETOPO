package backend.excecoes;

public class OperacaoNaoPermitidaException extends RuntimeException {
    public OperacaoNaoPermitidaException(String msg) { super(msg); }
}
