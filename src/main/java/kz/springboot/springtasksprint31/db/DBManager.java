package kz.springboot.springtasksprint31.db;

import kz.springboot.springtasksprint31.Models.Student;
import lombok.Getter;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DBManager {
    @Getter
    private static List<Student> students = new ArrayList<>();
    private static Long id = 3L;
    static {
        students.add(new Student(1L, "Sania", "Maripova", 100, "A"));
        students.add(new Student(2L, "Vlad", "Vlad", 80, "B"));
    }


    public static void addStudent(Student student) {
        student.setId(id);
        students.add(student);
        id++;
    }

    public static Student getStudentById(Long id) {
        return students.stream()
                .filter(student -> Objects.equals(student.getId(), id))
                .findFirst()
                .orElse(null);
    }


    public static void editStudent(Long id, String name, String surname, int exam) {
        Student student = getStudentById(id);
        if ( student==null ){
            return;
        }
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);

    }
}
