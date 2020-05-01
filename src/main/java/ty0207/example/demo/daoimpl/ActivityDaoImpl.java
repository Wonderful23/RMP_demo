package ty0207.example.demo.daoimpl;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ty0207.example.demo.dao.ActivityDao;
import ty0207.example.demo.entity.Activity;
import ty0207.example.demo.entity.User;

@Repository
public class ActivityDaoImpl implements ActivityDao {
    @Value("${RMP}")
    private String RMP_URL;
    @Override
    public Activity createActivity(Activity activity){
        String URL = RMP_URL+"Activity1/";
        RestTemplate restTemplate = new RestTemplate();
        Activity activity1 = new Activity();
        activity1.setName(activity.getName());
        ResponseEntity<JSONObject> result = restTemplate.postForEntity(URL,activity,JSONObject.class);
        Long id = (Long) result.getBody().get("id");
        activity.setId(id);
        return activity;
    }
}
