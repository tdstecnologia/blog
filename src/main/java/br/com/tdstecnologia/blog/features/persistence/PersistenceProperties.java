package br.com.tdstecnologia.blog.features.persistence;

import br.com.tdstecnologia.blog.features.exceptions.DaoException;
import java.util.Properties;

public class PersistenceProperties {

    private static final String DATABASE_URL = "DATABASE_URL";

    public Properties getConfigPersistence() {
        try {
            return variaveisAmbienteJdbc();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Properties variaveisAmbienteJdbc() throws DaoException {
        Properties props = new Properties();

        if (System.getenv().containsKey(DATABASE_URL)) {
            System.out.println(DATABASE_URL + " : " + System.getenv(DATABASE_URL));
        } else {
            throw new DaoException("Não foi  possível carregar as informaçõs da conexão");
        }
        return props;
    }

}
