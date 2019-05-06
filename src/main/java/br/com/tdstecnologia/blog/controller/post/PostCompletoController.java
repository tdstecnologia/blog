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
public class PostCompletoController implements Serializable {

    private PostVo postVo;
    private PostBe postBe;
    private FacesContext fc;

    public PostCompletoController() {

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

    public String excluirPost() {
        try {
            getPostBe().excluirPost(getPostVo());
            return "/index?faces-redirect=true";
        } catch (Exception e) {
            Jsf.Msg.erro(e.getMessage());
        }
        return null;
    }

    public PostVo getPostVo() {
        return postVo;
    }

    public void setPostVo(PostVo postVo) {
        this.postVo = postVo;
    }

    public PostBe getPostBe() {
        return postBe;
    }

    public void setPostBe(PostBe postBe) {
        this.postBe = postBe;
    }

}
