package ex3;

public class ClienteJaExistenteException extends RuntimeException {
    public ClienteJaExistenteException(String msg) {
        super(msg);
    }
}
