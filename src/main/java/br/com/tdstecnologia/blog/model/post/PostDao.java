package br.com.tdstecnologia.blog.model.post;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PostDao {

    private EntityManager em;

    public PostDao(EntityManager em) {
        this.em = em;
    }

    public void salvarPost(PostVo postVo) {
        this.em.persist(postVo);
    }

    public PostVo listarPosts() {
        TypedQuery query = em.createQuery("SELECT p FROM PostVo p", PostVo.class);
        List<PostVo> posts = query.getResultList();
        PostVo postVo = new PostVo();
        postVo.setListVo(posts);
        return postVo;
    }

}
