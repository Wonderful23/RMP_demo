package ty0207.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ty0207.example.demo.entity.Org;
import ty0207.example.demo.entity.Student;

public interface StudentRepository  {
    Long save(Student student);
    Student findById(Long id);

}
