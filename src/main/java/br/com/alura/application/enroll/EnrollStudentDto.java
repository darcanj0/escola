package br.com.alura.application.enroll;

public class EnrollStudentDto {
    public EnrollStudentDto(
            String name,
            String cpf,
            String email) {
        this.cpf = cpf;
        this.email = email;
        this.name = name;
    }

    String name;
    String cpf;
    String email;
}
