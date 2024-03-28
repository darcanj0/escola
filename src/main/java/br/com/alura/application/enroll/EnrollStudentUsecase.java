package br.com.alura.application.enroll;

import br.com.alura.application.Usecase;
import br.com.alura.domain.student.Student;
import br.com.alura.domain.student.StudentFactory;
import br.com.alura.domain.student.StudentRepository;

public class EnrollStudentUsecase implements Usecase<EnrollStudentDto, Boolean> {
    private StudentRepository repo;
    private StudentFactory factory;

    public EnrollStudentUsecase(
            StudentRepository repo) {
        this.repo = repo;
        this.factory = new StudentFactory();
    }

    @Override
    public Boolean execute(EnrollStudentDto params) {
        try {
            Student student = this.factory.fromData(params.name, params.cpf, params.email).create();
            this.repo.enroll(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
            return false;
        }

    }
}
