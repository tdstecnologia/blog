package br.com.tdstecnologia.blog.controller.post;

import br.com.tdstecnologia.blog.features.exceptions.DaoException;
import br.com.tdstecnologia.blog.features.jsf.Jsf;
import br.com.tdstecnologia.blog.model.post.PostBe;
import br.com.tdstecnologia.blog.model.post.PostVo;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AlterarPostController implements Serializable {

    private PostVo postVo;
    private PostBe postBe;
    private FacesContext fc;

    public AlterarPostController() {

    }

    @PostConstruct
    private void init() {
        this.postVo = new PostVo();
        this.postBe = new PostBe();
        fc = FacesContext.getCurrentInstance();
    }

    public void consultarPost() {
        try {
            Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
            PostVo param = new PostVo();
            param.setId(Long.valueOf(params.get("post_id")));
            setPostVo(getPostBe().consultarPostPorId(param));
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

    public String flowAlterarPost(final String postId){
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
