package br.com.tdstecnologia.blog.controller.usuario;

import br.com.tdstecnologia.blog.features.jsf.Jsf;
import br.com.tdstecnologia.blog.model.usuario.UsuarioBe;
import br.com.tdstecnologia.blog.model.usuario.UsuarioVo;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class NovoUsuarioController implements Serializable {

    private UsuarioVo usuarioVo;
    private UsuarioBe usuarioBe;

    public NovoUsuarioController() {
    }

    @PostConstruct
    private void init() {
        this.usuarioVo = new UsuarioVo();
        this.usuarioBe = new UsuarioBe();
    }

    public String flowNovoUsuario() {
        return "/usuario/novo-usuario";
    }

    public void salvarUsuario() {
        try {
            getUsuarioBe().salvarUsuario(usuarioVo);
            rotinaUsuarioSalvoSucesso();
        } catch (Exception e) {
            Jsf.Msg.erro(e);
        }
    }

    private void rotinaUsuarioSalvoSucesso() {
        this.usuarioVo = null;
        this.usuarioVo = new UsuarioVo();
        Jsf.Msg.sucesso("Usuario salvo...");
    }

    public UsuarioVo getUsuarioVo() {
        return usuarioVo;
    }

    public void setUsuarioVo(UsuarioVo usuarioVo) {
        this.usuarioVo = usuarioVo;
    }

    public UsuarioBe getUsuarioBe() {
        return usuarioBe;
    }

    public void setUsuarioBe(UsuarioBe usuarioBe) {
        this.usuarioBe = usuarioBe;
    }

}
