package br.com.tdstecnologia.blog.model.post;

import br.com.tdstecnologia.blog.features.exceptions.DaoException;
import br.com.tdstecnologia.blog.features.security.ControleAcesso;
import br.com.tdstecnologia.blog.model.abstracts.AbstractBe;
import br.com.tdstecnologia.blog.model.usuario.UsuarioVo;
import java.util.Date;
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
            postVo.setAutor(ControleAcesso.getUsuarioLogado());
            postVo.setDataCriacao(new Date());
            postVo.setDataPublicacao(new Date());
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

    public void salvarAlteracaoPost(PostVo postVo) throws Exception {
        EntityManager em = getManager();
        EntityTransaction tx = getTransacao();
        try {
            this.postDao = new PostDao(em);

            begin(tx);
            getPostDao().salvarAlteracaoPost(postVo);
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

    public PostVo listarPostsPorTexto(final String param) throws DaoException {
        EntityManager em = getManager();
        PostVo postVo = new PostVo();
        try {
            postVo = new PostDao(em).listarPostsPorTexto(param);
        } catch (DaoException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            close(em);
        }
        return postVo;
    }

    public PostVo listarMeusPosts(final UsuarioVo usuarioVo) throws DaoException {
        EntityManager em = getManager();
        PostVo posts = new PostVo();
        try {
            posts = new PostDao(em).listarMeusPosts(usuarioVo);
        } catch (DaoException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            close(em);
        }
        return posts;
    }

    public PostVo consultarPostPorId(final PostVo postVo) throws DaoException {
        EntityManager em = getManager();
        PostVo posts = new PostVo();
        try {
            posts = new PostDao(em).consultarPostPorId(postVo);
        } catch (DaoException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            close(em);
        }
        return posts;
    }

    public PostVo consultarPostPorIdAutor(final PostVo param) throws DaoException {
        EntityManager em = getManager();
        PostVo post = new PostVo();
        try {
            param.setAutor(ControleAcesso.getUsuarioLogado());
            post = new PostDao(em).consultarPostPorIdAutor(param);
        } catch (DaoException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            close(em);
        }
        return post;
    }

    public void excluirPost(final PostVo postVo) throws Exception {
        EntityManager em = getManager();
        EntityTransaction tx = getTransacao();
        try {
            begin(tx);
            PostDao postDao = new PostDao(em);
            postDao.excluirPost(postDao.consultarPostPorId(postVo));
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

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

}
