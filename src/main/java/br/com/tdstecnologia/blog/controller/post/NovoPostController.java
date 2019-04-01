package br.com.tdstecnologia.blog.controller.post;

import br.com.tdstecnologia.blog.model.post.PostVo;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class NovoPostController implements Serializable {

    private PostVo postVo;

    public NovoPostController() {
    }

    @PostConstruct
    private void init() {
        this.postVo = new PostVo();
    }

    public String flowNovoPost() {
        return "/post/novo-post";
    }

    public void salvarPost() {
        System.out.println("Salvando...");
        System.out.println("Post: " + postVo.toString());
    }

    public PostVo getPostVo() {
        return postVo;
    }

    public void setPostVo(PostVo postVo) {
        this.postVo = postVo;
    }

}