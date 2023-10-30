package kz.springboot.springtasksprint31.Controller;

import kz.springboot.springtasksprint31.Models.Student;
import kz.springboot.springtasksprint31.db.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage(Model model){
        List<Student> students = DBManager.getStudents();
        model.addAttribute("students", students);

        return "home";
    }
    @GetMapping("/student-details")
    public String studentDetails(@RequestParam(name = "studentId") Long id, Model model){
        Student student = DBManager.getStudentById(id);
        model.addAttribute("student", student);

        return "studentDetails";
    }

    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute Student student){
        DBManager.addStudent(student);
        return "redirect:/";
    }
    @GetMapping("/add-student")
    public String addStudentPage(){
        return "addStudent";
    }
    @PostMapping("/edit-student/{id}")
    public String editStudent(@RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam int exam,
                              @PathVariable Long id
    ){
        DBManager.editStudent(id, name, surname, exam);

        return "redirect:/";
    }
//    @GetMapping("/edit-student")
//    public String editStudentPage(){
//        return "editStudent";
//    }

}
