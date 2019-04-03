package br.com.tdstecnologia.blog.model.post;

import javax.persistence.EntityManager;

public class PostDao {

    private EntityManager em;

    public PostDao(EntityManager em) {
        this.em = em;
    }
    
    public void salvarPost(PostVo postVo) {
        this.em.persist(postVo);
    }

}
