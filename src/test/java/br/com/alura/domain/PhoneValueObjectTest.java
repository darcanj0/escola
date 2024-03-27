package br.com.alura.domain;

import org.junit.Test;

import br.com.alura.domain.value_objects.PhoneValueObject;

public class PhoneValueObjectTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowOnIllegal() {
        PhoneValueObject phone = new PhoneValueObject("00", "91001");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowOnNull() {
        PhoneValueObject phone = new PhoneValueObject(null, null);
    }

    @Test
    public void shouldCreateOnValid() {
        PhoneValueObject phone = new PhoneValueObject("61", "983474695");
    }
}
