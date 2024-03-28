package br.com.alura.application;

public interface Usecase <K, V> {
    V execute(K params);
}
