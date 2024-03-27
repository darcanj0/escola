package br.com.alura.domain.value_objects;

public class PhoneValueObject {
    private String ddd;
    private String value;

    public PhoneValueObject(String ddd, String numero) {
        if (ddd == null || numero == null) {
            throw new IllegalArgumentException("DDD e Numero sao obrigatorios");
        }

        if (!ddd.matches("\\d{2}")) {
            throw new IllegalArgumentException("DDD invalido!");
        }

        if (!numero.matches("\\d{8}|\\d{9}")) {
            throw new IllegalArgumentException("Numero invalido!");
        }
        this.ddd = ddd;
        this.value = numero;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return this.value == null;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final PhoneValueObject other = (PhoneValueObject) obj;

        if (this.value == null) {
            return other.value == null;
        }

        return (this.value == other.value) && (this.ddd == other.ddd);
    }
}
