package br.com.tdstecnologia.blog.model.post;

import br.com.tdstecnologia.blog.features.exceptions.DaoException;
import br.com.tdstecnologia.blog.model.usuario.UsuarioVo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class PostDao {

    private EntityManager em;

    public PostDao(EntityManager em) {
        this.em = em;
    }

    public void salvarPost(final PostVo postVo) throws DaoException {
        try {
            this.em.persist(postVo);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void salvarAlteracaoPost(final PostVo postVo) throws DaoException {
        try {
            this.em.merge(postVo);
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
    
    public PostVo consultarPostPorIdAutor(final PostVo param) throws DaoException {
        try {
            TypedQuery<PostVo> query = em.createQuery("SELECT p FROM PostVo p WHERE p.id = :id AND p.autor=:autor", PostVo.class);
            query.setParameter("id", param.getId());
            query.setParameter("autor", param.getAutor());
            return query.getSingleResult();
        }catch(NoResultException e){
            throw new DaoException("Nenhum registro encontrado");
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public PostVo listarMeusPosts(final UsuarioVo param) throws DaoException {
        try {
            TypedQuery query = em.createQuery("SELECT p FROM PostVo p WHERE p.autor=:autor", PostVo.class);
            query.setParameter("autor", param);
            List<PostVo> posts = query.getResultList();
            PostVo postVo = new PostVo();
            postVo.setListVo(posts);
            System.out.println("POSTS: " + postVo.getListVo().size());
            return postVo;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
    public PostVo listarPostsPorTexto(final String param) throws DaoException {
        try {
            TypedQuery query = em.createQuery("SELECT p FROM PostVo p WHERE LOWER(p.titulo) like :texto", PostVo.class);
            query.setParameter("texto", "%".concat(param.toLowerCase()).concat("%"));
            List<PostVo> posts = query.getResultList();
            PostVo postVo = new PostVo();
            postVo.setListVo(posts);
            System.out.println("POSTS: " + postVo.getListVo().size());
            return postVo;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void excluirPost(final PostVo postVo) throws DaoException {
        try {
            this.em.remove(postVo);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

}
