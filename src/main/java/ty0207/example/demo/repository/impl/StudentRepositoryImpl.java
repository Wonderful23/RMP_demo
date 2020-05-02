package ty0207.example.demo.repository.impl;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ty0207.example.demo.entity.Student;
import ty0207.example.demo.repository.StudentRepository;
import ty0207.example.demo.utils.HandlerJSON;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Value("${RMP}")
    private String RMP_URL;
    @Autowired
    private HandlerJSON handlerJSON;
    @Override
    public Long save(Student student){
        if(student.getId()<100){
            String URL = RMP_URL+"Student/";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<JSONObject> result = restTemplate.postForEntity(URL,student,JSONObject.class);
            Long id = (Long) result.getBody().get("id");
            return id;
        }else{
            String URL = RMP_URL+"Student/"+student.getId();
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put(URL,student);
            return student.getId();
        }
    }
    @Override
    public Student findById(Long id){
        String URL = RMP_URL+"Activity3/"+id;
        RestTemplate restTemplate = new RestTemplate();
        JSONObject result = restTemplate.getForObject(URL, JSONObject.class);

        return handlerJSON.hanlderStudentJSON(result);
    }
}
