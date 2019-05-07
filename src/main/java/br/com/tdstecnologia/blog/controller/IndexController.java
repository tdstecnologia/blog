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

    private String textoPesquisa;
    private PostVo postsVo;
    private PostBe postBe;

    public IndexController() {
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
        } catch (Exception e) {
            Jsf.Msg.erro(e);
        }
    }

    public void listarPostPorTexto() {
        try {
            System.out.println("Pesquisando por " + getTextoPesquisa());
            if (getTextoPesquisa().isEmpty()) {
                listarPost();
            } else if (getTextoPesquisa().length() > 3) {
                getPostsVo().setListVo(getPostBe().listarPostsPorTexto(getTextoPesquisa()).getListVo());
            }
        } catch (Exception e) {
            Jsf.Msg.erro(e);
        }
    }

    public String flowIndex() {
        return "/index";
    }

    public String getTextoPesquisa() {
        return textoPesquisa;
    }

    public void setTextoPesquisa(String textoPesquisa) {
        this.textoPesquisa = textoPesquisa;
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

}
