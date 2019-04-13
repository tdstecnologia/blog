package br.com.tdstecnologia.blog.features.exceptions;

public class ValidacaoException extends Exception {

    public ValidacaoException(final String msg) {
        super(msg);
    }
    
    public ValidacaoException(final Exception e) {
        super("Não foi possível realizar as validações", e);
    }

    public ValidacaoException(final String msg, final Exception e) {
        super(msg, e);
    }

}
