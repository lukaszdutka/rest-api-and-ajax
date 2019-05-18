package rsi.rest.crud.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rsi.rest.crud.repository.StudentRepository;
import rsi.rest.crud.dto.Student;

import java.util.List;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:8081", allowedHeaders = "*")
public class StudentController {

    private final StudentRepository studentRepository;

    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    @PostMapping(path = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        LOG.info("Using saveStudent method for: " + student);
        return ResponseEntity.ok(studentRepository.save(student));
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Student>> getAllStudents() {
        LOG.info("Using getAllStudents method.");
        return ResponseEntity.ok(studentRepository.getAll());
    }

    @GetMapping(path = "/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        LOG.info("Using getStudentById method for: " + studentId);
        return ResponseEntity.ok(studentRepository.get(studentId));
    }

    @PutMapping(path = "/")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        if (!studentRepository.contains(student.getId())) {
            LOG.info("Using updateStudent for USER NOT FOUND: " + student);
            return ResponseEntity.notFound().build();
        }
        LOG.info("Using updateStudent for USER FOUND: " + student);
        studentRepository.update(student);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping(path = "/{studentId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long studentId) {
        if (!studentRepository.contains(studentId)) {
            LOG.info("Using deleteStudent for USER ID NOT FOUND: " + studentId);
            return ResponseEntity.notFound().build();
        }
        LOG.info("Using deleteStudent for USER ID FOUND: " + studentId);
        studentRepository.delete(studentId);
        return ResponseEntity.ok().build();
    }
}
