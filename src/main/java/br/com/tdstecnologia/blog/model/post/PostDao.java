package br.com.tdstecnologia.blog.model.post;

import br.com.tdstecnologia.blog.features.exceptions.DaoException;
import br.com.tdstecnologia.blog.model.usuario.UsuarioVo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class PostDao {

    private EntityManager em;

    public PostDao(EntityManager em) {
        this.em = em;
    }

    public void salvarPost(PostVo postVo) throws DaoException {
        try {
            this.em.persist(postVo);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public PostVo consultarPostPorId(final PostVo postVo) throws DaoException {
        try {
            return em.find(PostVo.class, postVo.getId());
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public PostVo listarPosts() throws DaoException {
        try {
            TypedQuery query = em.createQuery("SELECT p FROM PostVo p", PostVo.class);
            List<PostVo> posts = query.getResultList();
            PostVo postVo = new PostVo();
            postVo.setListVo(posts);
            return postVo;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public PostVo listarMeusPosts(final UsuarioVo usuarioVo) throws DaoException {
        try {
            TypedQuery query = em.createQuery("SELECT p FROM PostVo p WHERE p.autor=:autor", PostVo.class);
            System.out.println("AUTOR: "+usuarioVo.getId() +" : "+usuarioVo.getNome());
            query.setParameter("autor", usuarioVo);
            List<PostVo> posts = query.getResultList();
            PostVo postVo = new PostVo();
            postVo.setListVo(posts);
            System.out.println("POSTS: "+postVo.getListVo().size());
            return postVo;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

}
