package br.com.alura.infra;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.alura.domain.student.PasswordEncrypter;

public class Md5PasswordEncrypter implements PasswordEncrypter {

    @Override
    public String encrypt(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(
                        Integer.toString(
                                (bytes[i] & 0xff) + 0x100));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("Error when encrypting password");
        }
    }

    @Override
    public boolean isCorrect(String encrypted, String original) {
        return encrypted.equals(encrypt(original));
    }

}
