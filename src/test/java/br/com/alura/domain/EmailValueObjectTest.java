package br.com.alura.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.alura.domain.value_objects.EmailValueObject;

public class EmailValueObjectTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowOnIllegal() {
        EmailValueObject email = new EmailValueObject("daniel.thomas.gmail.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowOnNull() {
        EmailValueObject email = new EmailValueObject(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldCreateOnValid() {
        EmailValueObject email = new EmailValueObject("daniel.thomas@gmail.com");
        assertEquals(new EmailValueObject("daniel.thomas@gmail.com"), email);
    }
}
