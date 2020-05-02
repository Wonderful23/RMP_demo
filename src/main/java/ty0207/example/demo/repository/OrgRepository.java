package ty0207.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ty0207.example.demo.entity.Activity;
import ty0207.example.demo.entity.Org;

public interface OrgRepository  {
    Long save(Org org);
    Org findById(Long id);
}
