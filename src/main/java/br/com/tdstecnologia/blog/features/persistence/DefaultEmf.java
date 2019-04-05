package br.com.tdstecnologia.blog.features.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DefaultEmf {

    private final static String BLOG_MYSQL_DS = "BLOG_MYSQL_PU";
    private final static String BLOG_PG_DS = "BLOG_PG_PU";
    private final EntityManagerFactory emf;
    private static final DefaultEmf INSTANCE = new DefaultEmf();

    private DefaultEmf() {
        this.emf = Persistence.createEntityManagerFactory(DefaultEmf.BLOG_PG_DS, new PersistenceProperties().getConfigPersistence());
        //this.emf = Persistence.createEntityManagerFactory(DefaultEmf.BLOG_PG_DS);
    }

    public static DefaultEmf getInstance() {
        return INSTANCE;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
    
}
