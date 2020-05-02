package ty0207.example.demo.repository.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ty0207.example.demo.entity.Activity;
import ty0207.example.demo.entity.Group;
import ty0207.example.demo.entity.Review;
import ty0207.example.demo.entity.Student;
import ty0207.example.demo.repository.GroupRepository;
import ty0207.example.demo.utils.HandlerJSON;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupRepositoryImpl implements GroupRepository {
    @Value("${RMP}")
    private String RMP_URL;
    @Autowired
    private HandlerJSON handlerJSON;
    @Override
    public Long save(Group group){
        if(group.getId()<100){
            String URL = RMP_URL+"Group/";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<JSONObject> result = restTemplate.postForEntity(URL,group,JSONObject.class);
            Long id = (Long) result.getBody().get("id");
            return id;
        }else{
            String URL = RMP_URL+"Group/"+group.getId();
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put(URL,group);
            return group.getId();
        }
    }
    @Override
    public Group findById(Long id){
        String URL = RMP_URL+"Group/"+id;
        RestTemplate restTemplate = new RestTemplate();
        JSONObject result = restTemplate.getForObject(URL, JSONObject.class);

        return handlerJSON.handlerGroupJSON(result);
    }

}
