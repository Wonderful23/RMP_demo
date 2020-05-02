package ty0207.example.demo.repository;

import ty0207.example.demo.entity.Review;

public interface ReviewRepository {

    Long save(Review review);
    Review findById(Long id);
}
