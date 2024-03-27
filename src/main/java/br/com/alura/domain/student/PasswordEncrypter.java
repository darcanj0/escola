package br.com.alura.domain.student;

public interface PasswordEncrypter {
    String encrypt(String password);

    boolean isCorrect(String encrypted, String original);
}
