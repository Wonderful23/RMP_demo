package ty0207.example.demo.repository.impl;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ty0207.example.demo.entity.Activity;
import ty0207.example.demo.entity.Review;
import ty0207.example.demo.repository.ReviewRepository;
import ty0207.example.demo.utils.HandlerJSON;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {
    @Value("${RMP}")
    private String RMP_URL;
    @Autowired
    private HandlerJSON handlerJSON;
    @Override
    public Long save(Review review){
        if(review.getId()<100){
            String URL = RMP_URL+"Review/";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<JSONObject> result = restTemplate.postForEntity(URL,review,JSONObject.class);
            Long id = (Long) result.getBody().get("id");
            return id;
        }else{
            String URL = RMP_URL+"Review/"+review.getId();
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put(URL,review);
            return review.getId();
        }
    }
    @Override
    public Review findById(Long id){
        String URL = RMP_URL+"Review/"+id;
        RestTemplate restTemplate = new RestTemplate();
        JSONObject result = restTemplate.getForObject(URL, JSONObject.class);

        return handlerJSON.handlerReviewJSON(result);
    }
}
