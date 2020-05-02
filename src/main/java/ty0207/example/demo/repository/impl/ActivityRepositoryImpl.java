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
import ty0207.example.demo.entity.Review;
import ty0207.example.demo.entity.Student;
import ty0207.example.demo.entity.User;
import ty0207.example.demo.repository.ActivityRepository;
import ty0207.example.demo.utils.HandlerJSON;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActivityRepositoryImpl implements ActivityRepository {
    @Value("${RMP}")
    private String RMP_URL;
    @Autowired
    private HandlerJSON handlerJSON;
    @Override
    public Long save(Activity activity){
        if(activity.getId()<100){
            String URL = RMP_URL+"Activity3/";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<JSONObject> result = restTemplate.postForEntity(URL,activity,JSONObject.class);
            Long id = (Long) result.getBody().get("id");
            return id;
        }else{
            String URL = RMP_URL+"Activity3/"+activity.getId();
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put(URL,activity);
            return activity.getId();
        }
    }
    @Override
    public Activity findById(Long id){
        String URL = RMP_URL+"Activity3/"+id;
        RestTemplate restTemplate = new RestTemplate();
        JSONObject result = restTemplate.getForObject(URL, JSONObject.class);

        return handlerJSON.handlerActivityJSON(result);
    }

}
