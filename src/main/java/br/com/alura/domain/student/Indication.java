package br.com.alura.domain.student;

import java.time.LocalDateTime;

public class Indication {
    private Student indicator;

    public Student getIndicator() {
        return indicator;
    }

    private Student indicated;

    public Student getIndicated() {
        return indicated;
    }

    private LocalDateTime at;

    public LocalDateTime getAt() {
        return at;
    }

    public Indication(Student indicator, Student indicated) {
        this.indicated = indicated;
        this.indicator = indicator;
        this.at = LocalDateTime.now();
    }
}
