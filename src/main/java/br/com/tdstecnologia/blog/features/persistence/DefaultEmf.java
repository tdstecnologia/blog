package br.com.tdstecnologia.blog.features.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DefaultEmf {

    private final static String BLOG_MYSQL_DS = "BLOG_PU";
    private final EntityManagerFactory emf;
    private static final DefaultEmf INSTANCE = new DefaultEmf();

    private DefaultEmf() {
        this.emf = Persistence.createEntityManagerFactory(DefaultEmf.BLOG_MYSQL_DS);
    }

    public static DefaultEmf getInstance() {
        return INSTANCE;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
    
}
