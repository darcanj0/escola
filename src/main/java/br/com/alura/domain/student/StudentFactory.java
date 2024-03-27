package br.com.alura.domain.student;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

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

    public StudentFactory withPhones(List<Map<String, String>> phones) {
        phones.forEach(new Consumer<Map<String, String>>() {
            @Override
            public void accept(Map<String, String> data) {
                PhoneValueObject phone = new PhoneValueObject(data.get("ddd"), data.get("phone"));
                student.addPhone(phone);
            }
        });
        return this;
    }

    public void clear() {
        this.student = null;
    }

    public Student create() {
        return this.student;
    }

    public StudentFactory() {
    };
}
