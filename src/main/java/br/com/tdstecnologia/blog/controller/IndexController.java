package br.com.tdstecnologia.blog.controller;

import br.com.tdstecnologia.blog.controller.post.*;
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
public class IndexController implements Serializable {

    private PostVo postsVo;
    private PostBe postBe;
    private FacesContext fc = FacesContext.getCurrentInstance();

    public IndexController() {
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        System.out.println("POST ID: "+params.get("post_id"));
    }

    @PostConstruct
    private void init() {
        this.postsVo = new PostVo();
        this.postBe = new PostBe();
        listarPost();
    }

    public void listarPost() {
        try {
            getPostsVo().setListVo(getPostBe().listarPosts().getListVo());
        } catch (DaoException e) {
            Jsf.Msg.erro(e);
        }
    }

    public String flowIndex() {
        return "/index";
    }

    public String flowVisualizarPostCompleto(final String postId) {
        return "/post/post-completo?faces-redirect=true&post_id=".concat(postId);
    }

    public PostVo getPostsVo() {
        return postsVo;
    }

    public void setPostsVo(PostVo postsVo) {
        this.postsVo = postsVo;
    }

    public PostBe getPostBe() {
        return postBe;
    }

    public void setPostBe(PostBe postBe) {
        this.postBe = postBe;
    }

}
