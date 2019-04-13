package br.com.tdstecnologia.blog.model.usuario;

import br.com.tdstecnologia.blog.features.email.UtilEmail;
import br.com.tdstecnologia.blog.features.exceptions.DaoException;
import br.com.tdstecnologia.blog.features.exceptions.ValidacaoException;
import br.com.tdstecnologia.blog.features.security.MD5;
import br.com.tdstecnologia.blog.model.abstracts.AbstractBe;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UsuarioBe extends AbstractBe {

    private UsuarioDao usuarioDao;

    public UsuarioBe() {
    }

    public void salvarUsuario(final UsuarioVo usuarioVo) throws Exception {
        EntityManager em = getManager();
        EntityTransaction tx = getTransacao();
        try {
            this.usuarioDao = new UsuarioDao(em);

            begin(tx);
            validarFormularioCadastroUsuario(usuarioVo);
            getUsuarioDao().salvarUsuario(usuarioVo);
            usuarioVo.setTokenAtivacao(MD5.gerarHashConfirmacaoCadastro());
            UtilEmail.confirmacaoDeCadastro(usuarioVo);
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

    public UsuarioDao getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public void validarFormularioCadastroUsuario(final UsuarioVo usuarioVo) throws Exception {
        isUsuarioJaExiste(usuarioVo);
    }

    public void isUsuarioJaExiste(final UsuarioVo usuarioVo) throws DaoException, Exception {
        EntityManager em = getManager();
        UsuarioVo us = new UsuarioDao(em).pesquisarUsuarioPorEmail(usuarioVo);
        if (us != null) {
            throw new ValidacaoException("Usuário já cadastrado");
        }
    }

}
