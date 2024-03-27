package br.com.alura.domain.student;

import br.com.alura.domain.value_objects.CpfValueObject;
import br.com.alura.domain.value_objects.EmailValueObject;
import br.com.alura.domain.value_objects.PhoneValueObject;

public class StudentFactory {
    private Student student;

    public StudentFactory fromData(String name, String cpf, String email) {
        this.student = new Student(new CpfValueObject(cpf), new EmailValueObject(email), name);
        return this;
    }

    public StudentFactory withPhone(String ddd, String phone) {
        this.student.addPhone(new PhoneValueObject(ddd, phone));
        return this;
    }

    public Student create() {
        return this.student;
    }

    public StudentFactory() {
    };
}
