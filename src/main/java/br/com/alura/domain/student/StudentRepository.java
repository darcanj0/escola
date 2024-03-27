package br.com.alura.domain.student;

import java.util.List;

import br.com.alura.domain.value_objects.CpfValueObject;

public interface StudentRepository {
    void enroll(Student student);

    Student getByCpf(CpfValueObject cpf);

    List<Student> getEnrolledStudents();
}
