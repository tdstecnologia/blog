package br.com.tdstecnologia.blog.features.security.http;

import java.net.InetAddress;

public class HttpContexto {

    public static String getUrlContexto() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("http://");
            sb.append(InetAddress.getLocalHost().getHostAddress());
            sb.append(":8080/");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String getUrlConfirmarCadastro(final String jwtToken) {
        String urlToken = getUrlContexto().concat("confirmar-cadastro?token=").concat(jwtToken);
        System.out.println("URL Token: " + urlToken);
        return urlToken;
    }

}
