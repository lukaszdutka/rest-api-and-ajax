package rsi.rest.crud.repository;

import org.springframework.stereotype.Repository;
import rsi.rest.crud.dto.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    private long nextId = 1;

    private Map<Long, Student> students = new HashMap<>();

    public Student save(Student student) {
        student.setId(nextId++);
        students.put(student.getId(), student);
        return student;
    }

    public void delete(Long id) {
        students.remove(id);
    }

    public void update(Student student) {
        students.put(student.getId(), student);
    }

    public boolean contains(Long id) {
        return id != null && students.containsKey(id);
    }

    public Student get(Long id) {
        return students.get(id);
    }

    public List<Student> getAll() {
        return new ArrayList<>(students.values());
    }
}
