package br.com.tdstecnologia.blog.model.post;

import br.com.tdstecnologia.blog.model.abstracts.AbstractBe;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PostBe extends AbstractBe {

    private PostDao postDao;

    public PostBe() {
    }

    public void salvarPost(PostVo postVo) {
        EntityManager em = getManager();
        EntityTransaction tx = getTransacao();
        try {
            this.postDao = new PostDao(em);

            begin(tx);
            getPostDao().salvarPost(postVo);
            commit(tx);
        } catch (Exception e) {
            e.printStackTrace();
            rollback(tx);
        } finally {
            close(em);
        }
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

}
