package ty0207.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ty0207.example.demo.entity.Activity;
import ty0207.example.demo.entity.Group;

public interface GroupRepository  {
    Long save(Group group);
    Group findById(Long id);
}
