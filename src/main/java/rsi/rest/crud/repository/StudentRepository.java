package rsi.rest.crud.repository;

import org.apache.logging.log4j.util.Strings;
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
        if(Strings.isNotBlank(student.getFirstName()) && Strings.isNotBlank(student.getLastName())){
            student.setId(nextId++);
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public void delete(Long id) {
        students.remove(id);
    }

    public void update(Student dataToUpdate) {
        Student studentDB = students.get(dataToUpdate.getId());
        if(Strings.isNotBlank(dataToUpdate.getFirstName())){
            studentDB.setFirstName(dataToUpdate.getFirstName());
        }
        if(Strings.isNotBlank(dataToUpdate.getLastName())){
            studentDB.setLastName(dataToUpdate.getLastName());
        }
        students.put(dataToUpdate.getId(), studentDB);
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
