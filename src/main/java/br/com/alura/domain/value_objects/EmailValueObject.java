package br.com.alura.domain.value_objects;

public class EmailValueObject {
    private String value;

    public EmailValueObject(String value) {
        if (value == null ||
                !value.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]{\\\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Ivalid E-mail!");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return this.value == null;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final EmailValueObject other = (EmailValueObject) obj;

        if (this.value == null) {
            return other.value == null;
        }

        return this.value == other.value;
    }
}
