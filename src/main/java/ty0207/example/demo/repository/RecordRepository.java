package ty0207.example.demo.repository;

import ty0207.example.demo.entity.Record;
import ty0207.example.demo.entity.Student;

public interface RecordRepository {
    Long save(Record record);
    Record findById(Long id);
}
