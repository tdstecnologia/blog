package br.com.tdstecnologia.blog.controller.post;

import br.com.tdstecnologia.blog.controller.AbstractController;
import br.com.tdstecnologia.blog.features.exceptions.DaoException;
import br.com.tdstecnologia.blog.features.jsf.Jsf;
import br.com.tdstecnologia.blog.model.post.PostBe;
import br.com.tdstecnologia.blog.model.post.PostVo;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AlterarPostController extends AbstractController {

    private PostVo postVo;
    private PostBe postBe;

    public AlterarPostController() {
    }

    @PostConstruct
    private void init() {
        this.postVo = new PostVo();
        this.postBe = new PostBe();
        
    }

    public void consultarPost() {
        try {
            PostVo param = new PostVo();
            param.setId(Long.valueOf(getParam("post_id")));
            setPostVo(getPostBe().consultarPostPorIdAutor(param));
        } catch (DaoException e) {
            Jsf.Msg.erro(e);
        }
    }

    public String salvarAlteracao() {
        try {
            getPostBe().salvarAlteracaoPost(getPostVo());
            return "/post/post-completo?faces-redirect=true&post_id=".concat(getPostVo().getId().toString());
        } catch (Exception e) {
            Jsf.Msg.erro(e.getMessage());
        }
        return null;
    }

    public String flowAlterarPost(final String postId) {
        return "/post/alterar-post?faces-redirect=true&post_id=".concat(postId);
    }

    public PostVo getPostVo() {
        return postVo;
    }

    public void setPostVo(PostVo postsVo) {
        this.postVo = postsVo;
    }

    public PostBe getPostBe() {
        return postBe;
    }

    public void setPostBe(PostBe postBe) {
        this.postBe = postBe;
    }

}
