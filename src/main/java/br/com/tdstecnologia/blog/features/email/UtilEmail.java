package br.com.tdstecnologia.blog.features.email;

import br.com.tdstecnologia.blog.features.jsf.Jsf;
import br.com.tdstecnologia.blog.features.security.http.HttpContexto;
import br.com.tdstecnologia.blog.model.usuario.UsuarioVo;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

public class UtilEmail {


    public static void recuperarSenhaDeAcesso(final UsuarioVo usuarioVo) throws Exception {
        try {
            String configEmail = System.getenv("EMAIL_CONFIG_GMAIL");
            List<String> configs = Arrays.asList(configEmail.split(";"));
            System.out.println("Config Email: "+configs);
            
            HtmlEmail email = new HtmlEmail();
            email.setHostName(configs.get(2));
            email.setSmtpPort(Integer.valueOf(configs.get(3)));
            email.setAuthenticator(new DefaultAuthenticator(configs.get(0), configs.get(1)));
            email.setSSLOnConnect(true);
            
            email.addTo(usuarioVo.getEmail(), usuarioVo.getNome());
            email.setFrom(configs.get(0), "Blog TDS Tecnologia");
            email.setSubject("Recuperar senha de acesso ao sistema Blog TDS Tecnologia");
            URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
            String cid = email.embed(url, "Apache logo");
            email.setHtmlMsg("<html>The apache logo - <img src=\"cid:" + cid + "\"></html>");
            email.setTextMsg("Your email client does not support HTML messages");
            email.send();
            Jsf.Msg.sucesso("E-mail enviado. Por favor verifique sua caixa de entrada");
        } catch (Exception e) {
            throw new Exception("Não foi possível enviar o e-mail de recuperação senha", e);
        }

    }

    public static void confirmacaoDeCadastro(final UsuarioVo usuarioVo) throws Exception {
        try {
            String configEmail = System.getenv("EMAIL_CONFIG_GMAIL");
            List<String> configs = Arrays.asList(configEmail.split(";"));
            System.out.println("Config Email: "+configs);
            
            HtmlEmail email = new HtmlEmail();
            email.setHostName(configs.get(2));
            email.setSmtpPort(Integer.valueOf(configs.get(3)));
            email.setAuthenticator(new DefaultAuthenticator(configs.get(0), configs.get(1)));
            email.setSSLOnConnect(true);
            
            email.addTo(usuarioVo.getEmail(), usuarioVo.getNome());
            email.setFrom(configs.get(0), "Blog TDS Tecnologia");
            email.setSubject("Blog TDS Tecnologia - Confirmação de Cadastro");

            URL url = new URL(HttpContexto.getUrlConfirmarCadastro(usuarioVo.getTokenAtivacao()));
            email.setHtmlMsg("<html>Clique no link para confimar seu cadastro - <a href=\"" + url.toString() + "\">Confirmar Cadastro</a></html>");
            email.setTextMsg("Aparentemente seu e-mail não suporta conteúdo HTML");
            email.send();
            Jsf.Msg.sucesso("Email enviado...");
        } catch (Exception e) {
            throw new Exception("Falha no envio do e-mail", e);
        }

    }

}
