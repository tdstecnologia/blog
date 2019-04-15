package br.com.tdstecnologia.blog.model.usuario;

import br.com.tdstecnologia.blog.features.exceptions.DaoException;
import br.com.tdstecnologia.blog.model.abstracts.AbstractDao;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UsuarioDao extends AbstractDao {

    public UsuarioDao(EntityManager em) {
        super(em);
    }

    public void salvarUsuario(UsuarioVo usuarioVo) throws DaoException {
        try {
            getEm().persist(usuarioVo);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public UsuarioVo pesquisarUsuarioPorEmail(final UsuarioVo usuarioVo) throws DaoException {
        try {
            TypedQuery<UsuarioVo> query = getEm().createQuery("SELECT u FROM UsuarioVo u WHERE u.email = :email", UsuarioVo.class);
            query.setParameter("email", usuarioVo.getEmail());
            UsuarioVo usuario = query.getSingleResult();
            return usuario;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
    
     public UsuarioVo pesquisarUsuarioPorEmailSenha(final UsuarioVo usuarioVo) throws DaoException {
        try {
            TypedQuery<UsuarioVo> query = getEm().createQuery("SELECT u FROM UsuarioVo u WHERE u.email = :email AND u.senha = :senha", UsuarioVo.class);
            query.setParameter("email", usuarioVo.getEmail());
            query.setParameter("senha", usuarioVo.getSenha());
            UsuarioVo usuario = query.getSingleResult();
            return usuario;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
