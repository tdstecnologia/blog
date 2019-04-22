package br.com.tdstecnologia.blog.model.acesso;

import br.com.tdstecnologia.blog.features.exceptions.DaoException;
import br.com.tdstecnologia.blog.features.security.ControleAcesso;
import br.com.tdstecnologia.blog.model.abstracts.AbstractBe;
import br.com.tdstecnologia.blog.model.usuario.UsuarioDao;
import br.com.tdstecnologia.blog.model.usuario.UsuarioVo;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class AcessoBe extends AbstractBe {

    private UsuarioDao usuarioDao;

    public void login(final UsuarioVo usuarioVo) throws DaoException {
        EntityManager em = getManager();
        try {
            this.usuarioDao = new UsuarioDao(em);
            UsuarioVo usuario = usuarioDao.pesquisarUsuarioPorEmailSenha(usuarioVo);
            if(usuario != null){
                ControleAcesso.login(usuario);
            }
        } catch (NoResultException e) {
            throw new DaoException("Verifique os dados informados", e);
        } catch (DaoException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            close(em);
        }
    }

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

}
