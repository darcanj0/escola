package br.com.alura.domain.value_objects;

import java.util.regex.Pattern;

public class EmailValueObject {
    private String value;

    private static String regex = "^(.+)@(\\S+)$";

    public String getValue() {
        return value;
    }

    public EmailValueObject(String value) {
        if (value == null ||
                !Pattern.compile(EmailValueObject.regex).matcher(value).matches()) {
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
