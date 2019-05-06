package br.com.tdstecnologia.blog.model.abstracts;

import br.com.tdstecnologia.blog.features.persistence.DefaultEmf;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public abstract class AbstractBe {

    private EntityManager em;

    protected EntityManager getManager() {
        if (this.em == null || !this.em.isOpen()) {
            em = DefaultEmf.getInstance().getEmf().createEntityManager();
            System.out.println("Conexão aberta: " + em.hashCode());
        }
        return em;
    }

    protected EntityTransaction getTransacao() {
        return getManager().getTransaction();
    }

    protected void commit(final EntityTransaction tx) {
        if (tx != null && tx.isActive()) {
            tx.commit();
        }
    }

    protected void begin(final EntityTransaction tx) {
        if (tx != null) {
            tx.begin();
        }
    }

    protected void rollback(final EntityTransaction tx) {
        if (tx != null) {
            tx.rollback();
        }
    }

    protected void close(EntityManager em) {
        if (em != null) {
            if (em.isOpen()) {
                if (em.hashCode() == this.em.hashCode()) {
                    em.close();
                    System.out.println("Conexão fechada: "+ em.hashCode());
                    em = null;
                }
            }
        }
    }

}
