package br.com.tdstecnologia.blog.controller.post;

import br.com.tdstecnologia.blog.features.jsf.Jsf;
import br.com.tdstecnologia.blog.model.post.PostBe;
import br.com.tdstecnologia.blog.model.post.PostVo;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class NovoPostController implements Serializable {
    
    private PostVo postVo;
    private PostBe postBe;
    
    public NovoPostController() {
    }
    
    @PostConstruct
    private void init() {
        this.postVo = new PostVo();
        this.postBe = new PostBe();
    }
    
    public String flowNovoPost() {
        return "/post/novo-post";
    }
    
    public void salvarPost() {
        try {
            getPostBe().salvarPost(postVo);
            Jsf.Msg.sucesso("Post salvo...");
        } catch (Exception e) {
            Jsf.Msg.erro(e);
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
