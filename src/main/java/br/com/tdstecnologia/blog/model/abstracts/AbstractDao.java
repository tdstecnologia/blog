package br.com.tdstecnologia.blog.model.abstracts;

import javax.persistence.EntityManager;

public abstract class AbstractDao {

    private EntityManager em;

    public AbstractDao(EntityManager em) {
        this.em = em;
    }

    protected EntityManager getEm() {
        return em;
    }

    protected void setEm(EntityManager em) {
        this.em = em;
    }
    
    
}
