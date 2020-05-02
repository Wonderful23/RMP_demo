package ty0207.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ty0207.example.demo.entity.Activity;

public interface ActivityRepository {
    Long save(Activity activity);
    Activity findById(Long id);
}
