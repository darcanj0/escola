package br.com.alura;

import br.com.alura.application.enroll.EnrollStudentDto;
import br.com.alura.application.enroll.EnrollStudentUsecase;
import br.com.alura.domain.student.StudentRepository;
import br.com.alura.infra.JdbcStudentRepository;

public class App {
    public static void main(String[] args) {
        StudentRepository repo = new JdbcStudentRepository();
        EnrollStudentUsecase usecase = new EnrollStudentUsecase(repo);

        boolean result = usecase.execute(new EnrollStudentDto("Daniel", "123.456.789-00", "fulano@email.com"));

        System.out.println(result);
    }
}
