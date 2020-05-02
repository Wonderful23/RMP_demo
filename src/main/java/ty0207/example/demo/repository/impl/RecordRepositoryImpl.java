package ty0207.example.demo.repository.impl;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ty0207.example.demo.entity.Record;
import ty0207.example.demo.entity.Review;
import ty0207.example.demo.repository.RecordRepository;
import ty0207.example.demo.utils.HandlerJSON;

@Repository
public class RecordRepositoryImpl implements RecordRepository {
    @Value("${RMP}")
    private String RMP_URL;
    @Autowired
    private HandlerJSON handlerJSON;
    @Override
    public Long save(Record record){
        if(record.getId()<100){
            String URL = RMP_URL+"Record/";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<JSONObject> result = restTemplate.postForEntity(URL,record,JSONObject.class);
            Long id = (Long) result.getBody().get("id");
            return id;
        }else{
            String URL = RMP_URL+"Record/"+record.getId();
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put(URL,record);
            return record.getId();
        }
    }
    @Override
    public Record findById(Long id){
        String URL = RMP_URL+"Record/"+id;
        RestTemplate restTemplate = new RestTemplate();
        JSONObject result = restTemplate.getForObject(URL, JSONObject.class);

        return handlerJSON.handlerRecordJSON(result);
    }
}
