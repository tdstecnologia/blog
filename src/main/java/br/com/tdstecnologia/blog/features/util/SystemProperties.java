package br.com.tdstecnologia.blog.features.util;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class SystemProperties {

    public static class Email {

        public static final String HOSTNAME = "HOSTNAME";
        public static final String SMTP_PORT = "SMTP_PORT";
        public static final String USER = "USER";
        public static final String PASSWORD = "PASSWORD";
    }

    public static Properties getConfigEmail() {
        String configEmail = System.getenv("EMAIL_CONFIG_GMAIL");
        List<String> configs = Arrays.asList(configEmail.split("|"));
        Properties props = new Properties();
        props.put(Email.USER, configs.get(0));
        props.put(Email.PASSWORD, configs.get(1));
        props.put(Email.HOSTNAME, configs.get(2));
        props.put(Email.SMTP_PORT, configs.get(3));
        return props;
    }

    public static void main(String[] args) {
        System.out.println(getConfigEmail());
    }
}
