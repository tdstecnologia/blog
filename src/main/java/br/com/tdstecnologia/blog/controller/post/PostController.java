package br.com.tdstecnologia.blog.controller.post;

import br.com.tdstecnologia.blog.features.exceptions.DaoException;
import br.com.tdstecnologia.blog.features.jsf.Jsf;
import br.com.tdstecnologia.blog.model.post.PostBe;
import br.com.tdstecnologia.blog.model.post.PostVo;
import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PostController implements Serializable {

    private PostVo postsVo;
    private PostBe postBe;

    public PostController() {
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
    
     public String flowVisualizarPostCompleto() {
        return "/post/post-completo";
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
