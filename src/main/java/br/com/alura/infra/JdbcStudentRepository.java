package br.com.alura.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.domain.student.Student;
import br.com.alura.domain.student.StudentFactory;
import br.com.alura.domain.student.StudentRepository;
import br.com.alura.domain.value_objects.CpfValueObject;
import br.com.alura.domain.value_objects.PhoneValueObject;

public class JdbcStudentRepository implements StudentRepository {

    private Connection conn;
    private StudentFactory studentFactory;

    @Override
    public void enroll(Student student) {
        String command = "INSERT INTO STUDENTS VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(command);
            ps.setString(1, student.getCpf().getValue());
            ps.setString(2, student.getEmail().getValue());
            ps.setString(3, student.getName());
            ps.execute();

            command = "INSERT INTO PHONES VALUES(?, ?)";
            ps = conn.prepareStatement(command);
            for (PhoneValueObject phone : student.getPhones()) {
                ps.setString(1, phone.getDdd());
                ps.setString(2, phone.getValue());
                ps.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student getByCpf(CpfValueObject cpf) {
        String command = "SELECT id, name, email FROM STUDENTS WHERE cpf = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(command);
            ps.setString(1, cpf.getValue());
            ResultSet result = ps.executeQuery();
            boolean found = result.next();
            if (!found) {
                throw new RuntimeException("Student not found");
            }

            Student foundStudent = studentFactory
                    .fromData(
                            result.getString("name"), cpf.getValue(), result.getString("email"))
                    .create();

            Long id = result.getLong("id");

            command = "SELECT ddd, phone FROM PHONES WHERE student_id = ?";
            ps = conn.prepareStatement(command);
            ps.setLong(1, id);
            result = ps.executeQuery();
            while (result.next()) {
                String phone = result.getString("phone");
                String ddd = result.getString("ddd");
                foundStudent.addPhone(new PhoneValueObject(ddd, phone));
            }
            return foundStudent;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> getEnrolledStudents() {
        try {
            String command = "SELECT id, cpf, name, email FROM STUDENTS";
            PreparedStatement ps = conn.prepareStatement(command);
            ResultSet rs = ps.executeQuery();
            List<Student> students = new ArrayList<Student>();
            while (rs.next()) {
                studentFactory.clear();
                Student student = studentFactory
                        .fromData(rs.getString("name"), rs.getString("cpf"), rs.getString("email")).create();

                Long id = rs.getLong("id");
                command = "SELECT ddd, phone FROM PHONES WHERE student_id = ?";
                PreparedStatement psPhone = conn.prepareStatement(command);
                psPhone.setLong(1, id);
                ResultSet rsPhone = psPhone.executeQuery();

                while (rsPhone.next()) {
                    student.addPhone(
                            new PhoneValueObject(rsPhone.getString("ddd"), rsPhone.getString("phone"))

                    );
                }
                students.add(student);
            }
            return students;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public JdbcStudentRepository() {
        this.studentFactory = new StudentFactory();
    }

}
