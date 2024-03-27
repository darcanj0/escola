package br.com.alura.application;

import br.com.alura.domain.student.Student;

public interface MailerService {
    void sendIndicationEmail(Student to);
}
