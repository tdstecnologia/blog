package br.com.tdstecnologia.blog.model.usuario;

import br.com.tdstecnologia.blog.features.exceptions.DaoException;
import br.com.tdstecnologia.blog.model.abstracts.AbstractDao;
import javax.persistence.EntityManager;

public class UsuarioDao extends AbstractDao{
    
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
}
