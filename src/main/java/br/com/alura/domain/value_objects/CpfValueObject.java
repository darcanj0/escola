package br.com.alura.domain.value_objects;

public class CpfValueObject {

    private String value;

    public CpfValueObject(String value) {
        if (value == null ||
                !value.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("Invalid CPF!");
        }
        this.value = value;
    }
}
