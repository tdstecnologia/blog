package br.com.tdstecnologia.blog.model.post;

import br.com.tdstecnologia.blog.features.exceptions.DaoException;
import br.com.tdstecnologia.blog.model.abstracts.AbstractBe;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PostBe extends AbstractBe {

    private PostDao postDao;

    public PostBe() {
    }

    public void salvarPost(PostVo postVo) throws Exception {
        EntityManager em = getManager();
        EntityTransaction tx = getTransacao();
        try {
            this.postDao = new PostDao(em);

            begin(tx);
            getPostDao().salvarPost(postVo);
            commit(tx);
        } catch (DaoException e) {
            rollback(tx);
            throw e;
        } catch (Exception e) {
            rollback(tx);
            throw e;
        } finally {
            close(em);
        }
    }

    public PostVo listarPosts() throws DaoException {
        EntityManager em = getManager();
        PostVo posts = new PostVo();
        try {
            posts = new PostDao(em).listarPosts();
        } catch (DaoException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            close(em);
        }
        return posts;
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

}
