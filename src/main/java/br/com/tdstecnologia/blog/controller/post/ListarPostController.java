package br.com.tdstecnologia.blog.controller.post;

import br.com.tdstecnologia.blog.features.exceptions.DaoException;
import br.com.tdstecnologia.blog.features.jsf.Jsf;
import br.com.tdstecnologia.blog.features.security.ControleAcesso;
import br.com.tdstecnologia.blog.model.post.PostBe;
import br.com.tdstecnologia.blog.model.post.PostVo;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ListarPostController implements Serializable {

    private PostVo postVo;
    private PostBe postBe;

    public ListarPostController() {
    }

    @PostConstruct
    private void init() {
        this.postVo = new PostVo();
        this.postBe = new PostBe();
        listarMeusPosts();
    }
  
    public String flowMeusPost() {
        return "/post/listar-posts";
    }

    public void listarMeusPosts() {
        try {
            setPostVo(postBe.listarMeusPosts(ControleAcesso.getUsuarioLogado()));
            System.out.println("POSTS C : "+postVo.getListVo().size());
        } catch (DaoException ex) {
            Logger.getLogger(ListarPostController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PostVo getPostVo() {
        return postVo;
    }

    public void setPostVo(PostVo postVo) {
        this.postVo = postVo;
    }

    private PostBe getPostBe() {
        return postBe;
    }

}
