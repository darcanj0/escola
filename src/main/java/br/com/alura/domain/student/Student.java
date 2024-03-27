package br.com.alura.domain.student;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.domain.value_objects.CpfValueObject;
import br.com.alura.domain.value_objects.EmailValueObject;
import br.com.alura.domain.value_objects.PhoneValueObject;

public class Student {
    private Long enroll;
    private String name;
    private CpfValueObject cpf;
    private EmailValueObject email;
    private List<PhoneValueObject> phones = new ArrayList<PhoneValueObject>();

    public Student addPhone(PhoneValueObject phone) {
        this.phones.add(phone);
        return this;
    }

    public Student(
            CpfValueObject cpf,
            EmailValueObject email,
            String name) {
        this.cpf = cpf;
        this.email = email;
        this.name = name;
    }
}
