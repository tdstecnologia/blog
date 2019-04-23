package br.com.tdstecnologia.blog.features.exceptions;

public class UsuarioNaoLogadoException extends RuntimeException{

    public UsuarioNaoLogadoException() {
        super("Usuario não está logado");
    }
    
    
}
