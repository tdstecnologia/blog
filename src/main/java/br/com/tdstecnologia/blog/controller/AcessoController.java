package br.com.tdstecnologia.blog.controller;

import br.com.tdstecnologia.blog.features.jsf.Jsf;
import br.com.tdstecnologia.blog.model.acesso.AcessoBe;
import br.com.tdstecnologia.blog.model.usuario.UsuarioVo;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AcessoController implements Serializable {

    private UsuarioVo usuarioVo;
    private AcessoBe acessoBe;

    public AcessoController() {

    }

    public String login() {
        try {
            getAcessoBe().login(usuarioVo);
            return "/index?faces-redirect=true";
        } catch (Exception e) {
            Jsf.Msg.erro(e);
        }
        return null;
    }

    public String flowLogin() {
        return "/login";
    }
    
    public String flowLogOut() {
        return "/logout?faces-redirect=true";
    }
    
    public String flowIndex() {
        return "/index?faces-redirect=true";
    }

    public AcessoBe getAcessoBe() {
        if (this.acessoBe == null) {
            this.acessoBe = new AcessoBe();
        }
        return acessoBe;
    }

    public UsuarioVo getUsuarioVo() {
        if (this.usuarioVo == null) {
            this.usuarioVo = new UsuarioVo();
        }
        return usuarioVo;
    }

    public void setUsuarioVo(UsuarioVo usuarioVo) {
        this.usuarioVo = usuarioVo;
    }

}
