package br.com.tdstecnologia.blog.features.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.xml.bind.DatatypeConverter;

public class MD5 {

    public static String gerarHashConfirmacaoCadastro() throws NoSuchAlgorithmException {
        Long numero = new Random().nextLong();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(numero.toString().getBytes());
        byte[] digest = md.digest();
        String hashMD5 = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return hashMD5;
    }

}
