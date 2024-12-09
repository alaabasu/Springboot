package com.example.demo.Controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Student;
import com.example.demo.models.University;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;



@Controller
public class StudentController {

    private static final String XML_FILE_PATH = "src/main/resources/university.xml";
    private List<Student> studentList = loadStudentsFromXml();

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "AddStudent";  // AddStudent.html should be in resources/templates
    }

    @PostMapping("/students")
    public String addStudents(@ModelAttribute University university, Model model) {
        List<Student> students = university.getStudents();

        // Check for duplicate student IDs
        for (Student student : students) {
            if (studentList.stream().anyMatch(existingStudent -> existingStudent.getId().equals(student.getId()))) {
                model.addAttribute("message", "Student with ID " + student.getId() + " already exists.");
                return "AddStudent";  // Return to the AddStudent form with an error message
            }
        }

        // Add new students to the list and save to XML
        studentList.addAll(students);
        saveStudentsToXml(studentList);

        return "redirect:/add"; // Redirect to the form after successful submission
    }

  // Show all students to select for editing
  @GetMapping("/edit")
  public String showAllStudentsForEdit(Model model) {
      List<Student> students = loadStudentsFromXml();
      model.addAttribute("students", students);
      return "SelectStudent";  // New page for selecting a student
  }

  // Load the editing form for the selected student
  @GetMapping("/editStudent")
  public String showEditForm(@RequestParam("id") String id, Model model) {
      List<Student> students = loadStudentsFromXml();  // Load latest student data
      Optional<Student> student = students.stream()
          .filter(s -> s.getId().equals(id))
          .findFirst();

      if (student.isPresent()) {
          model.addAttribute("student", student.get());
          return "EditStudent";  // Page for editing the selected student
      } else {
          model.addAttribute("message", "Student not found.");
          return "redirect:/edit";  // Redirect back to selection page if not found
      }
  }

  // Handle the update after editing the student
  @PostMapping("/updateStudent")
  public String updateStudent(@ModelAttribute Student student, Model model) {
     // List<Student> students = loadStudentsFromXml();  // Load the latest list of students
      studentList = studentList.stream()
          .map(existingStudent -> existingStudent.getId().equals(student.getId()) ? student : existingStudent)
          .collect(Collectors.toList());
  
      // Save the updated list to XML
      saveStudentsToXml(studentList);  // Save the updated list back to XML
  
      model.addAttribute("message", "Student updated successfully.");
      return "redirect:/edit";  // Redirect back to selection page after update
  }


    @GetMapping("/searchStudent")
    public String showSearchForm(Model model) {
        model.addAttribute("results", new ArrayList<Student>());
        model.addAttribute("count", 0);  // Initial count
        return "SearchStudent";
    }
    
    @PostMapping("/searchStudent")
    public String searchStudent(@RequestParam String attributeType,
                                @RequestParam String attributeValue,
                                Model model) {
        List<Student> results = new ArrayList<>();
        List<Student> studentsFromXml = loadStudentsFromXml();
    
        for (Student student : studentsFromXml) {
            boolean matches = false;
    
            switch (attributeType) {
                case "id":
                    matches = student.getId().equalsIgnoreCase(attributeValue);
                    break;
                case "firstName":
                    matches = student.getFirstName().equalsIgnoreCase(attributeValue);
                    break;
                case "lastName":
                    matches = student.getLastName().equalsIgnoreCase(attributeValue);
                    break;
                case "gender":
                    matches = student.getGender().equalsIgnoreCase(attributeValue);
                    break;
                case "gpa":
                    matches = student.getGpa().equals(Double.valueOf(attributeValue));
                    break;
                case "level":
                    matches = student.getLevel().equals(Integer.valueOf(attributeValue));
                    break;
                case "address":
                    matches = student.getAddress().equalsIgnoreCase(attributeValue);
                    break;
                default:
                    break;
            }
    
            if (matches) {
                results.add(student);
            }
        }
    
        model.addAttribute("results", results);
        model.addAttribute("count", results.size());  // Add the count of found students
        return "SearchStudent";
    }

    @GetMapping("/sortStudents")
public String showSortForm(Model model) {
    model.addAttribute("attributes", List.of("id", "firstName", "lastName", "gpa", "level", "gender", "address"));
    return "SortStudents"; // View for sorting form
}

@PostMapping("/sortStudents")
public String sortStudents(@RequestParam("attributeType") String attributeType,
                        @RequestParam("order") String order,
                        Model model) {
    List<Student> students = loadStudentsFromXml();

    Comparator<Student> comparator;
    switch (attributeType) {
        case "id":
            comparator = Comparator.comparingInt(student -> Integer.parseInt(student.getId()));
            break;
        case "firstName":
            comparator = Comparator.comparing(Student::getFirstName, String.CASE_INSENSITIVE_ORDER);
            break;
        case "lastName":
            comparator = Comparator.comparing(Student::getLastName, String.CASE_INSENSITIVE_ORDER);
            break;
        case "gpa":
            comparator = Comparator.comparing(Student::getGpa);
            break;
        case "level":
            comparator = Comparator.comparing(Student::getLevel);
            break;
        case "gender":
            comparator = Comparator.comparing(Student::getGender, String.CASE_INSENSITIVE_ORDER);
            break;
        case "address":
            comparator = Comparator.comparing(Student::getAddress, String.CASE_INSENSITIVE_ORDER);
            break;
        default:
            throw new IllegalArgumentException("Invalid attribute: " + attributeType);
    }

    if ("desc".equalsIgnoreCase(order)) {
        comparator = comparator.reversed();
    }

    students.sort(comparator);
    saveStudentsToXml(students);

    model.addAttribute("message", "Students sorted successfully by " + attributeType + " in " + order + " order.");
    model.addAttribute("results", students);
    return "SortStudents";
}

    
    

    
    
    @GetMapping("/delete")
    public String showDeleteForm(Model model) {
        model.addAttribute("message", null);  // Initially no message
        return "DeleteStudent";  // Returns the delete form view
    }



    @PostMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") String studentId, Model model) {
        List<Student> students = loadStudentsFromXml();  // Load students from the XML file
        
        // Find and remove the student by ID
        List<Student> filteredStudents = students.stream()
                .filter(student -> !student.getId().equals(studentId))
                .collect(Collectors.toList());

        // If the student was deleted, update the XML
        if (filteredStudents.size() < students.size()) {
            saveStudentsToXml(filteredStudents);
            model.addAttribute("message", "Student with ID " + studentId + " has been deleted.");
        } else {
            model.addAttribute("message", "Student with ID " + studentId + " not found.");
        }

        return "DeleteStudent";  // Return to the same page with a message
    }
    private void saveStudentsToXml(List<Student> students) {
        try {
            JAXBContext context = JAXBContext.newInstance(University.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            University university = new University();
            university.setStudents(students);

            marshaller.marshal(university, new File(XML_FILE_PATH));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private List<Student> loadStudentsFromXml() {
        try {
            File file = new File(XML_FILE_PATH);
            if (!file.exists()) {
                return new ArrayList<>();
            }

            JAXBContext context = JAXBContext.newInstance(University.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            University university = (University) unmarshaller.unmarshal(file);

            return university.getStudents();
        } catch (JAXBException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
