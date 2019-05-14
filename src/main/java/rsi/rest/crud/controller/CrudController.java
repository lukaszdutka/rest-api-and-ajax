package rsi.rest.crud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rsi.rest.crud.repository.StudentRepository;
import rsi.rest.crud.dto.Student;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CrudController {

    private final StudentRepository studentRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.getAll();
    }

    @GetMapping(path = "/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentRepository.get(studentId);
    }

    @PutMapping
    public ResponseEntity updateStudent(@RequestBody Student student) {
        if (!studentRepository.contains(student.getId())) {
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
        studentRepository.update(student);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable Long studentId) {
        if (!studentRepository.contains(studentId)) {
            return new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }
        studentRepository.delete(studentId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
