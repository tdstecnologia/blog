package br.com.tdstecnologia.blog.controller;

import br.com.tdstecnologia.blog.features.security.ControleAcesso;
import br.com.tdstecnologia.blog.model.usuario.UsuarioVo;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class AcessoWeb implements Serializable {

    private UsuarioVo usuario;

    public AcessoWeb() {
    }

    public UsuarioVo getUsuario() {
        if (this.usuario == null) {
            this.usuario = ControleAcesso.getUsuarioLogado();
        }
        return usuario;
    }

    public boolean isUsuarioLogado() {
        return ControleAcesso.isUsuarioLogado();

    }

}
